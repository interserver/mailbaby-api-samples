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

import MailBaby.Model
import MailBaby.MimeTypes

main :: IO ()
main =
  hspec $ modifyMaxSize (const 10) $ do
    describe "JSON instances" $ do
      pure ()
      propMimeEq MimeJSON (Proxy :: Proxy ErrorResponse)
      propMimeEq MimeJSON (Proxy :: Proxy GenericResponse)
      propMimeEq MimeJSON (Proxy :: Proxy MailAttachment)
      propMimeEq MimeJSON (Proxy :: Proxy MailContact)
      propMimeEq MimeJSON (Proxy :: Proxy MailLog)
      propMimeEq MimeJSON (Proxy :: Proxy MailOrder)
      propMimeEq MimeJSON (Proxy :: Proxy SendMail)
      
