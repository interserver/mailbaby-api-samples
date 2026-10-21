{-# LANGUAGE ScopedTypeVariables #-}
{-# LANGUAGE OverloadedStrings #-}
{-# LANGUAGE RecordWildCards #-}
{-# LANGUAGE PartialTypeSignatures #-}

module Main where

import Data.Typeable (Proxy(..))
import Test.Hspec
import Test.Hspec.QuickCheck

import PropMime
import Instances ()

import MailBabyEmailDeliveryAndManagementService.Model
import MailBabyEmailDeliveryAndManagementService.MimeTypes

main :: IO ()
main =
  hspec $ modifyMaxSize (const 10) $ do
    describe "JSON instances" $ do
      pure ()
      propMimeEq MimeJSON (Proxy :: Proxy DateOrTimestamp)
      propMimeEq MimeJSON (Proxy :: Proxy DenyRuleNew)
      propMimeEq MimeJSON (Proxy :: Proxy DenyRuleRecord)
      propMimeEq MimeJSON (Proxy :: Proxy EmailAddressName)
      propMimeEq MimeJSON (Proxy :: Proxy EmailAddressParam)
      propMimeEq MimeJSON (Proxy :: Proxy EmailAddressTypes)
      propMimeEq MimeJSON (Proxy :: Proxy EmailAddressesTypes)
      propMimeEq MimeJSON (Proxy :: Proxy ErrorMessage)
      propMimeEq MimeJSON (Proxy :: Proxy GenericResponse)
      propMimeEq MimeJSON (Proxy :: Proxy MailAttachment)
      propMimeEq MimeJSON (Proxy :: Proxy MailBlockClickHouse)
      propMimeEq MimeJSON (Proxy :: Proxy MailBlockRspamd)
      propMimeEq MimeJSON (Proxy :: Proxy MailBlocks)
      propMimeEq MimeJSON (Proxy :: Proxy MailLog)
      propMimeEq MimeJSON (Proxy :: Proxy MailLogEntry)
      propMimeEq MimeJSON (Proxy :: Proxy MailOrder)
      propMimeEq MimeJSON (Proxy :: Proxy MailOrderDetail)
      propMimeEq MimeJSON (Proxy :: Proxy MailStatsType)
      propMimeEq MimeJSON (Proxy :: Proxy MailStatsVolume)
      propMimeEq MimeJSON (Proxy :: Proxy SendMail)
      propMimeEq MimeJSON (Proxy :: Proxy SendMailAdv)
      propMimeEq MimeJSON (Proxy :: Proxy SendMailRaw)
      propMimeEq MimeJSON (Proxy :: Proxy SendMailTo)
      
