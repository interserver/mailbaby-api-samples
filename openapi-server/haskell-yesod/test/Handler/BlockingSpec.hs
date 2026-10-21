{-# LANGUAGE NoImplicitPrelude #-}
{-# LANGUAGE OverloadedStrings #-}
module Handler.BlockingSpec (spec) where

import           TestImport


spec :: Spec
spec = withApp $ do

    describe "postMailRulesR" $
        it "returns 501 Not Implemented" $ do
            post MailRulesR
            statusIs 501

    describe "deleteMailRulesByIntR" $
        it "returns 501 Not Implemented" $ do
            performMethod "DELETE" $ MailRulesByIntR 34
            statusIs 501

    describe "postMailBlocksDeleteR" $
        it "returns 501 Not Implemented" $ do
            post MailBlocksDeleteR
            statusIs 501

    describe "getMailBlocksR" $
        it "returns 501 Not Implemented" $ do
            get MailBlocksR
            statusIs 501

    describe "getMailRulesR" $
        it "returns 501 Not Implemented" $ do
            get MailRulesR
            statusIs 501
