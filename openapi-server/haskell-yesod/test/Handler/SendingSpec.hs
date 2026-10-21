{-# LANGUAGE NoImplicitPrelude #-}
{-# LANGUAGE OverloadedStrings #-}
module Handler.SendingSpec (spec) where

import           TestImport


spec :: Spec
spec = withApp $ do

    describe "postMailRawsendR" $
        it "returns 501 Not Implemented" $ do
            post MailRawsendR
            statusIs 501

    describe "postMailAdvsendR" $
        it "returns 501 Not Implemented" $ do
            post MailAdvsendR
            statusIs 501

    describe "postMailSendR" $
        it "returns 501 Not Implemented" $ do
            post MailSendR
            statusIs 501
