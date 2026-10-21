{-# LANGUAGE CPP #-}
{-# OPTIONS_GHC -fno-warn-unused-imports -fno-warn-unused-matches #-}

module Instances where

import MailBabyEmailDeliveryAndManagementService.Model
import MailBabyEmailDeliveryAndManagementService.Core

import qualified Data.Aeson as A
import qualified Data.ByteString.Lazy as BL
import qualified Data.HashMap.Strict as HM
import qualified Data.Set as Set
import qualified Data.Text as T
import qualified Data.Time as TI
import qualified Data.Vector as V
import Data.String (fromString)

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

#if MIN_VERSION_aeson(2,0,0)
#else
-- | A naive Arbitrary instance for A.Value:
instance Arbitrary A.Value where
  arbitrary = arbitraryValue
#endif

arbitraryValue :: Gen A.Value
arbitraryValue =
  frequency [(3, simpleTypes), (1, arrayTypes), (1, objectTypes)]
    where
      simpleTypes :: Gen A.Value
      simpleTypes =
        frequency
          [ (1, return A.Null)
          , (2, liftM A.Bool (arbitrary :: Gen Bool))
          , (2, liftM (A.Number . fromIntegral) (arbitrary :: Gen Int))
          , (2, liftM (A.String . T.pack) (arbitrary :: Gen String))
          ]
      mapF (k, v) = (fromString k, v)
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

instance Arbitrary DateOrTimestamp where
  arbitrary = sized genDateOrTimestamp

genDateOrTimestamp :: Int -> Gen DateOrTimestamp
genDateOrTimestamp n =
  
  pure DateOrTimestamp
   
instance Arbitrary DenyRuleNew where
  arbitrary = sized genDenyRuleNew

genDenyRuleNew :: Int -> Gen DenyRuleNew
genDenyRuleNew n =
  DenyRuleNew
    <$> arbitrary -- denyRuleNewType :: E'Type
    <*> arbitrary -- denyRuleNewData :: Text
    <*> arbitraryReducedMaybe n -- denyRuleNewUser :: Maybe Text
  
instance Arbitrary DenyRuleRecord where
  arbitrary = sized genDenyRuleRecord

genDenyRuleRecord :: Int -> Gen DenyRuleRecord
genDenyRuleRecord n =
  DenyRuleRecord
    <$> arbitrary -- denyRuleRecordType :: E'Type
    <*> arbitrary -- denyRuleRecordData :: Text
    <*> arbitrary -- denyRuleRecordId :: Text
    <*> arbitraryReduced n -- denyRuleRecordCreated :: DateTime
    <*> arbitraryReducedMaybe n -- denyRuleRecordUser :: Maybe Text
  
instance Arbitrary EmailAddressName where
  arbitrary = sized genEmailAddressName

genEmailAddressName :: Int -> Gen EmailAddressName
genEmailAddressName n =
  EmailAddressName
    <$> arbitrary -- emailAddressNameEmail :: Text
    <*> arbitraryReducedMaybe n -- emailAddressNameName :: Maybe Text
  
instance Arbitrary EmailAddressParam where
  arbitrary = sized genEmailAddressParam

genEmailAddressParam :: Int -> Gen EmailAddressParam
genEmailAddressParam n =
  EmailAddressParam
    <$> arbitrary -- emailAddressParamEmail :: Text
  
instance Arbitrary EmailAddressTypes where
  arbitrary = sized genEmailAddressTypes

genEmailAddressTypes :: Int -> Gen EmailAddressTypes
genEmailAddressTypes n =
  EmailAddressTypes
    <$> arbitrary -- emailAddressTypesEmail :: Text
    <*> arbitraryReducedMaybe n -- emailAddressTypesName :: Maybe Text
  
instance Arbitrary EmailAddressesTypes where
  arbitrary = sized genEmailAddressesTypes

genEmailAddressesTypes :: Int -> Gen EmailAddressesTypes
genEmailAddressesTypes n =
  
  pure EmailAddressesTypes
   
instance Arbitrary ErrorMessage where
  arbitrary = sized genErrorMessage

genErrorMessage :: Int -> Gen ErrorMessage
genErrorMessage n =
  ErrorMessage
    <$> arbitrary -- errorMessageCode :: Int
    <*> arbitrary -- errorMessageMessage :: Text
  
instance Arbitrary GenericResponse where
  arbitrary = sized genGenericResponse

genGenericResponse :: Int -> Gen GenericResponse
genGenericResponse n =
  GenericResponse
    <$> arbitrary -- genericResponseStatus :: Text
    <*> arbitrary -- genericResponseText :: Text
  
instance Arbitrary MailAttachment where
  arbitrary = sized genMailAttachment

genMailAttachment :: Int -> Gen MailAttachment
genMailAttachment n =
  MailAttachment
    <$> arbitrary -- mailAttachmentFilename :: Text
    <*> arbitraryReduced n -- mailAttachmentData :: ByteArray
  
instance Arbitrary MailBlockClickHouse where
  arbitrary = sized genMailBlockClickHouse

genMailBlockClickHouse :: Int -> Gen MailBlockClickHouse
genMailBlockClickHouse n =
  MailBlockClickHouse
    <$> arbitraryReduced n -- mailBlockClickHouseDate :: Date
    <*> arbitrary -- mailBlockClickHouseFrom :: Text
    <*> arbitrary -- mailBlockClickHouseSubject :: Text
    <*> arbitrary -- mailBlockClickHouseTo :: Text
    <*> arbitraryReducedMaybe n -- mailBlockClickHouseMessageId :: Maybe Text
  
instance Arbitrary MailBlockRspamd where
  arbitrary = sized genMailBlockRspamd

genMailBlockRspamd :: Int -> Gen MailBlockRspamd
genMailBlockRspamd n =
  MailBlockRspamd
    <$> arbitrary -- mailBlockRspamdFrom :: Text
    <*> arbitrary -- mailBlockRspamdSubject :: Text
  
instance Arbitrary MailBlocks where
  arbitrary = sized genMailBlocks

genMailBlocks :: Int -> Gen MailBlocks
genMailBlocks n =
  MailBlocks
    <$> arbitraryReduced n -- mailBlocksLocal :: [MailBlockClickHouse]
    <*> arbitraryReduced n -- mailBlocksMbtrap :: [MailBlockClickHouse]
    <*> arbitraryReduced n -- mailBlocksSubject :: [MailBlockRspamd]
  
instance Arbitrary MailLog where
  arbitrary = sized genMailLog

genMailLog :: Int -> Gen MailLog
genMailLog n =
  MailLog
    <$> arbitrary -- mailLogTotal :: Int
    <*> arbitrary -- mailLogSkip :: Int
    <*> arbitrary -- mailLogLimit :: Int
    <*> arbitraryReduced n -- mailLogEmails :: [MailLogEntry]
  
instance Arbitrary MailLogEntry where
  arbitrary = sized genMailLogEntry

genMailLogEntry :: Int -> Gen MailLogEntry
genMailLogEntry n =
  MailLogEntry
    <$> arbitrary -- mailLogEntryId :: Int
    <*> arbitrary -- mailLogEntryId :: Text
    <*> arbitrary -- mailLogEntryFrom :: Text
    <*> arbitrary -- mailLogEntryTo :: Text
    <*> arbitrary -- mailLogEntryCreated :: Text
    <*> arbitrary -- mailLogEntryTime :: Int
    <*> arbitrary -- mailLogEntryUser :: Text
    <*> arbitrary -- mailLogEntryTranstype :: Text
    <*> arbitrary -- mailLogEntryOrigin :: Text
    <*> arbitrary -- mailLogEntryInterface :: Text
    <*> arbitraryReducedMaybe n -- mailLogEntrySubject :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryMessageId :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntrySendingZone :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryBodySize :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailLogEntrySeq :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailLogEntryDelivered :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailLogEntryCode :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailLogEntryResponse :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryRecipient :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryDomain :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryLocked :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailLogEntryLockTime :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryAssigned :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryQueued :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailLogEntryMxHostname :: Maybe Text
  
instance Arbitrary MailOrder where
  arbitrary = sized genMailOrder

genMailOrder :: Int -> Gen MailOrder
genMailOrder n =
  MailOrder
    <$> arbitrary -- mailOrderId :: Int
    <*> arbitrary -- mailOrderStatus :: E'Status
    <*> arbitrary -- mailOrderUsername :: Text
    <*> arbitraryReducedMaybe n -- mailOrderComment :: Maybe Text
  
instance Arbitrary MailOrderDetail where
  arbitrary = sized genMailOrderDetail

genMailOrderDetail :: Int -> Gen MailOrderDetail
genMailOrderDetail n =
  MailOrderDetail
    <$> arbitrary -- mailOrderDetailId :: Int
    <*> arbitrary -- mailOrderDetailStatus :: E'Status
    <*> arbitrary -- mailOrderDetailUsername :: Text
    <*> arbitrary -- mailOrderDetailPassword :: Text
    <*> arbitraryReducedMaybe n -- mailOrderDetailComment :: Maybe Text
  
instance Arbitrary MailStatsType where
  arbitrary = sized genMailStatsType

genMailStatsType :: Int -> Gen MailStatsType
genMailStatsType n =
  MailStatsType
    <$> arbitraryReducedMaybe n -- mailStatsTypeTime :: Maybe E'Time
    <*> arbitraryReducedMaybe n -- mailStatsTypeUsage :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailStatsTypeCurrency :: Maybe Text
    <*> arbitraryReducedMaybe n -- mailStatsTypeCost :: Maybe Double
    <*> arbitraryReducedMaybe n -- mailStatsTypeReceived :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailStatsTypeSent :: Maybe Int
    <*> arbitraryReducedMaybe n -- mailStatsTypeVolume :: Maybe MailStatsVolume
  
instance Arbitrary MailStatsVolume where
  arbitrary = sized genMailStatsVolume

genMailStatsVolume :: Int -> Gen MailStatsVolume
genMailStatsVolume n =
  MailStatsVolume
    <$> arbitraryReducedMaybe n -- mailStatsVolumeTo :: Maybe (Map.Map String Int)
    <*> arbitraryReducedMaybe n -- mailStatsVolumeFrom :: Maybe (Map.Map String Int)
    <*> arbitraryReducedMaybe n -- mailStatsVolumeIp :: Maybe (Map.Map String Int)
  
instance Arbitrary SendMail where
  arbitrary = sized genSendMail

genSendMail :: Int -> Gen SendMail
genSendMail n =
  SendMail
    <$> arbitraryReduced n -- sendMailTo :: SendMailTo
    <*> arbitrary -- sendMailFrom :: Text
    <*> arbitrary -- sendMailSubject :: Text
    <*> arbitrary -- sendMailBody :: Text
    <*> arbitraryReducedMaybe n -- sendMailId :: Maybe Integer
  
instance Arbitrary SendMailAdv where
  arbitrary = sized genSendMailAdv

genSendMailAdv :: Int -> Gen SendMailAdv
genSendMailAdv n =
  SendMailAdv
    <$> arbitrary -- sendMailAdvSubject :: Text
    <*> arbitrary -- sendMailAdvBody :: Text
    <*> arbitraryReduced n -- sendMailAdvFrom :: EmailAddressTypes
    <*> arbitraryReduced n -- sendMailAdvTo :: EmailAddressesTypes
    <*> arbitraryReducedMaybe n -- sendMailAdvReplyto :: Maybe EmailAddressesTypes
    <*> arbitraryReducedMaybe n -- sendMailAdvCc :: Maybe EmailAddressesTypes
    <*> arbitraryReducedMaybe n -- sendMailAdvBcc :: Maybe EmailAddressesTypes
    <*> arbitraryReducedMaybe n -- sendMailAdvAttachments :: Maybe [MailAttachment]
    <*> arbitraryReducedMaybe n -- sendMailAdvId :: Maybe Integer
  
instance Arbitrary SendMailRaw where
  arbitrary = sized genSendMailRaw

genSendMailRaw :: Int -> Gen SendMailRaw
genSendMailRaw n =
  SendMailRaw
    <$> arbitrary -- sendMailRawRawEmail :: Text
    <*> arbitraryReducedMaybe n -- sendMailRawId :: Maybe Integer
  
instance Arbitrary SendMailTo where
  arbitrary = sized genSendMailTo

genSendMailTo :: Int -> Gen SendMailTo
genSendMailTo n =
  
  pure SendMailTo
   



instance Arbitrary E'Delivered where
  arbitrary = arbitraryBoundedEnum

instance Arbitrary E'Dir where
  arbitrary = arbitraryBoundedEnum

instance Arbitrary E'Groupby where
  arbitrary = arbitraryBoundedEnum

instance Arbitrary E'Sort where
  arbitrary = arbitraryBoundedEnum

instance Arbitrary E'Status where
  arbitrary = arbitraryBoundedEnum

instance Arbitrary E'Time where
  arbitrary = arbitraryBoundedEnum

instance Arbitrary E'Type where
  arbitrary = arbitraryBoundedEnum

