@isTest
private class OASEmailAddressParamTest {
    @isTest
    private static void equalsSameInstance() {
        OASEmailAddressParam emailAddressParam1 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam2 = emailAddressParam1;
        OASEmailAddressParam emailAddressParam3 = new OASEmailAddressParam();
        OASEmailAddressParam emailAddressParam4 = emailAddressParam3;

        System.assert(emailAddressParam1.equals(emailAddressParam2));
        System.assert(emailAddressParam2.equals(emailAddressParam1));
        System.assert(emailAddressParam1.equals(emailAddressParam1));
        System.assert(emailAddressParam3.equals(emailAddressParam4));
        System.assert(emailAddressParam4.equals(emailAddressParam3));
        System.assert(emailAddressParam3.equals(emailAddressParam3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASEmailAddressParam emailAddressParam1 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam2 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam3 = new OASEmailAddressParam();
        OASEmailAddressParam emailAddressParam4 = new OASEmailAddressParam();

        System.assert(emailAddressParam1.equals(emailAddressParam2));
        System.assert(emailAddressParam2.equals(emailAddressParam1));
        System.assert(emailAddressParam3.equals(emailAddressParam4));
        System.assert(emailAddressParam4.equals(emailAddressParam3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASEmailAddressParam emailAddressParam1 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam2 = new OASEmailAddressParam();

        System.assertEquals(false, emailAddressParam1.equals('foo'));
        System.assertEquals(false, emailAddressParam2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASEmailAddressParam emailAddressParam1 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam2 = new OASEmailAddressParam();
        OASEmailAddressParam emailAddressParam3;

        System.assertEquals(false, emailAddressParam1.equals(emailAddressParam3));
        System.assertEquals(false, emailAddressParam2.equals(emailAddressParam3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASEmailAddressParam emailAddressParam1 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam2 = new OASEmailAddressParam();

        System.assertEquals(emailAddressParam1.hashCode(), emailAddressParam1.hashCode());
        System.assertEquals(emailAddressParam2.hashCode(), emailAddressParam2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASEmailAddressParam emailAddressParam1 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam2 = OASEmailAddressParam.getExample();
        OASEmailAddressParam emailAddressParam3 = new OASEmailAddressParam();
        OASEmailAddressParam emailAddressParam4 = new OASEmailAddressParam();

        System.assert(emailAddressParam1.equals(emailAddressParam2));
        System.assert(emailAddressParam3.equals(emailAddressParam4));
        System.assertEquals(emailAddressParam1.hashCode(), emailAddressParam2.hashCode());
        System.assertEquals(emailAddressParam3.hashCode(), emailAddressParam4.hashCode());
    }
}
