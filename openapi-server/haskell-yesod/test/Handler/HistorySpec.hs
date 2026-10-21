{-# LANGUAGE NoImplicitPrelude #-}
{-# LANGUAGE OverloadedStrings #-}
module Handler.HistorySpec (spec) where

import           TestImport


spec :: Spec
spec = withApp $ do

    describe "getMailStatsR" $
        it "returns 501 Not Implemented" $ do
            get MailStatsR
            statusIs 501

    describe "getMailLogR" $
        it "returns 501 Not Implemented" $ do
            get MailLogR
            statusIs 501
