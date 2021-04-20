{-# OPTIONS_GHC -fno-warn-unused-imports -fno-warn-unused-matches #-}

module Instances where

import MailBaby.Model
import MailBaby.Core

import qualified Data.Aeson as A
import qualified Data.ByteString.Lazy as BL
import qualified Data.HashMap.Strict as HM
import qualified Data.Set as Set
import qualified Data.Text as T
import qualified Data.Time as TI
import qualified Data.Vector as V

import Control.Monad
import Data.Char (isSpace)
import Data.List (sort)
import Test.QuickCheck

import ApproxEq

instance Arbitrary T.Text where
  arbitrary = T.pack <$> arbitrary

instance Arbitrary TI.Day where
  arbitrary = TI.ModifiedJulianDay . (2000 +) <$> arbitrary
  shrink = (TI.ModifiedJulianDay <$>) . shrink . TI.toModifiedJulianDay

instance Arbitrary TI.UTCTime where
  arbitrary =
    TI.UTCTime <$> arbitrary <*> (TI.secondsToDiffTime <$> choose (0, 86401))

instance Arbitrary BL.ByteString where
    arbitrary = BL.pack <$> arbitrary
    shrink xs = BL.pack <$> shrink (BL.unpack xs)

instance Arbitrary ByteArray where
    arbitrary = ByteArray <$> arbitrary
    shrink (ByteArray xs) = ByteArray <$> shrink xs

instance Arbitrary Binary where
    arbitrary = Binary <$> arbitrary
    shrink (Binary xs) = Binary <$> shrink xs

instance Arbitrary DateTime where
    arbitrary = DateTime <$> arbitrary
    shrink (DateTime xs) = DateTime <$> shrink xs

instance Arbitrary Date where
    arbitrary = Date <$> arbitrary
    shrink (Date xs) = Date <$> shrink xs

-- | A naive Arbitrary instance for A.Value:
instance Arbitrary A.Value where
  arbitrary = frequency [(3, simpleTypes), (1, arrayTypes), (1, objectTypes)]
    where
      simpleTypes :: Gen A.Value
      simpleTypes =
        frequency
          [ (1, return A.Null)
          , (2, liftM A.Bool (arbitrary :: Gen Bool))
          , (2, liftM (A.Number . fromIntegral) (arbitrary :: Gen Int))
          , (2, liftM (A.String . T.pack) (arbitrary :: Gen String))
          ]
      mapF (k, v) = (T.pack k, v)
      simpleAndArrays = frequency [(1, sized sizedArray), (4, simpleTypes)]
      arrayTypes = sized sizedArray
      objectTypes = sized sizedObject
      sizedArray n = liftM (A.Array . V.fromList) $ replicateM n simpleTypes
      sizedObject n =
        liftM (A.object . map mapF) $
        replicateM n $ (,) <$> (arbitrary :: Gen String) <*> simpleAndArrays
    
-- | Checks if a given list has no duplicates in _O(n log n)_.
hasNoDups
  :: (Ord a)
  => [a] -> Bool
hasNoDups = go Set.empty
  where
    go _ [] = True
    go s (x:xs)
      | s' <- Set.insert x s
      , Set.size s' > Set.size s = go s' xs
      | otherwise = False

instance ApproxEq TI.Day where
  (=~) = (==)
    
arbitraryReduced :: Arbitrary a => Int -> Gen a
arbitraryReduced n = resize (n `div` 2) arbitrary

arbitraryReducedMaybe :: Arbitrary a => Int -> Gen (Maybe a)
arbitraryReducedMaybe 0 = elements [Nothing]
arbitraryReducedMaybe n = arbitraryReduced n

arbitraryReducedMaybeValue :: Int -> Gen (Maybe A.Value)
arbitraryReducedMaybeValue 0 = elements [Nothing]
arbitraryReducedMaybeValue n = do
  generated <- arbitraryReduced n
  if generated == Just A.Null
    then return Nothing
    else return generated

-- * Models
 
instance Arbitrary ErrorResponse where
  arbitrary = sized genErrorResponse

genErrorResponse :: Int -> Gen ErrorResponse
genErrorResponse n =
  ErrorResponse
    <$> arbitrary -- errorResponseCode :: Text
    <*> arbitrary -- errorResponseMessage :: Text
  
instance Arbitrary GenericResponse where
  arbitrary = sized genGenericResponse

genGenericResponse :: Int -> Gen GenericResponse
genGenericResponse n =
  GenericResponse
    <$> arbitraryReducedMaybe n -- genericResponseStatus :: Maybe Text
    <*> arbitraryReducedMaybe n -- genericResponseStatusText :: Maybe Text
  
instance Arbitrary MailAttachment where
  arbitrary = sized genMailAttachment

genMailAttachment :: Int -> Gen MailAttachment
genMailAttachment n =
  MailAttachment
    <$> arbitraryReducedMaybe n -- mailAttachmentFilename :: Maybe Text
    <*> arbitrary -- mailAttachmentData :: FilePath
  
instance Arbitrary MailContact where
  arbitrary = sized genMailContact

genMailContact :: Int -> Gen MailContact
genMailContact n =
  MailContact
    <$> arbitrary -- mailContactEmail :: Text
    <*> arbitraryReducedMaybe n -- mailContactName :: Maybe Text
  
instance Arbitrary MailLog where
  arbitrary = sized genMailLog

genMailLog :: Int -> Gen MailLog
genMailLog n =
  MailLog
    <$> arbitraryReducedMaybe n -- mailLogId :: Maybe Integer
  
instance Arbitrary MailOrder where
  arbitrary = sized genMailOrder

genMailOrder :: Int -> Gen MailOrder
genMailOrder n =
  MailOrder
    <$> arbitrary -- mailOrderId :: Int
    <*> arbitrary -- mailOrderStatus :: Text
    <*> arbitrary -- mailOrderUsername :: Text
    <*> arbitraryReducedMaybe n -- mailOrderPassword :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailOrderComment :: Maybe Text
  
instance Arbitrary SendMail where
  arbitrary = sized genSendMail

genSendMail :: Int -> Gen SendMail
genSendMail n =
  SendMail
    <$> arbitrary -- sendMailId :: Integer
    <*> arbitraryReduced n -- sendMailFrom :: MailContact
    <*> arbitraryReduced n -- sendMailTo :: [MailContact]
    <*> arbitrary -- sendMailSubject :: Text
    <*> arbitrary -- sendMailBody :: Text
    <*> arbitraryReducedMaybe n -- sendMailReplyto :: Maybe [MailContact]
    <*> arbitraryReducedMaybe n -- sendMailCc :: Maybe [MailContact]
    <*> arbitraryReducedMaybe n -- sendMailBcc :: Maybe [MailContact]
    <*> arbitraryReducedMaybe n -- sendMailAttachments :: Maybe [MailAttachment]
  



