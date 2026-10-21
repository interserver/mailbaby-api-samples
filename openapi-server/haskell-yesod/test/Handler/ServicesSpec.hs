{-# LANGUAGE NoImplicitPrelude #-}
{-# LANGUAGE OverloadedStrings #-}
module Handler.ServicesSpec (spec) where

import           TestImport


spec :: Spec
spec = withApp $ do

    describe "getMailByInt64R" $
        it "returns 501 Not Implemented" $ do
            get $ MailByInt64R 39
            statusIs 501

    describe "getMailR" $
        it "returns 501 Not Implemented" $ do
            get MailR
            statusIs 501
