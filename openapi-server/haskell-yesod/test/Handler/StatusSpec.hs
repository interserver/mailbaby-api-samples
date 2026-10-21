{-# LANGUAGE NoImplicitPrelude #-}
{-# LANGUAGE OverloadedStrings #-}
module Handler.StatusSpec (spec) where

import           TestImport


spec :: Spec
spec = withApp $ do

    describe "getPingR" $
        it "returns 501 Not Implemented" $ do
            get PingR
            statusIs 501
