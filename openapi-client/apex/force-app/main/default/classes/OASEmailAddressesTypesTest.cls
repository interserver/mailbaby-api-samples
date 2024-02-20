@isTest
private class OASEmailAddressesTypesTest {
    @isTest
    private static void equalsSameInstance() {
        OASEmailAddressesTypes emailAddressesTypes1 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes2 = emailAddressesTypes1;
        OASEmailAddressesTypes emailAddressesTypes3 = new OASEmailAddressesTypes();
        OASEmailAddressesTypes emailAddressesTypes4 = emailAddressesTypes3;

        System.assert(emailAddressesTypes1.equals(emailAddressesTypes2));
        System.assert(emailAddressesTypes2.equals(emailAddressesTypes1));
        System.assert(emailAddressesTypes1.equals(emailAddressesTypes1));
        System.assert(emailAddressesTypes3.equals(emailAddressesTypes4));
        System.assert(emailAddressesTypes4.equals(emailAddressesTypes3));
        System.assert(emailAddressesTypes3.equals(emailAddressesTypes3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASEmailAddressesTypes emailAddressesTypes1 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes2 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes3 = new OASEmailAddressesTypes();
        OASEmailAddressesTypes emailAddressesTypes4 = new OASEmailAddressesTypes();

        System.assert(emailAddressesTypes1.equals(emailAddressesTypes2));
        System.assert(emailAddressesTypes2.equals(emailAddressesTypes1));
        System.assert(emailAddressesTypes3.equals(emailAddressesTypes4));
        System.assert(emailAddressesTypes4.equals(emailAddressesTypes3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASEmailAddressesTypes emailAddressesTypes1 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes2 = new OASEmailAddressesTypes();

        System.assertEquals(false, emailAddressesTypes1.equals('foo'));
        System.assertEquals(false, emailAddressesTypes2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASEmailAddressesTypes emailAddressesTypes1 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes2 = new OASEmailAddressesTypes();
        OASEmailAddressesTypes emailAddressesTypes3;

        System.assertEquals(false, emailAddressesTypes1.equals(emailAddressesTypes3));
        System.assertEquals(false, emailAddressesTypes2.equals(emailAddressesTypes3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASEmailAddressesTypes emailAddressesTypes1 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes2 = new OASEmailAddressesTypes();

        System.assertEquals(emailAddressesTypes1.hashCode(), emailAddressesTypes1.hashCode());
        System.assertEquals(emailAddressesTypes2.hashCode(), emailAddressesTypes2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASEmailAddressesTypes emailAddressesTypes1 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes2 = OASEmailAddressesTypes.getExample();
        OASEmailAddressesTypes emailAddressesTypes3 = new OASEmailAddressesTypes();
        OASEmailAddressesTypes emailAddressesTypes4 = new OASEmailAddressesTypes();

        System.assert(emailAddressesTypes1.equals(emailAddressesTypes2));
        System.assert(emailAddressesTypes3.equals(emailAddressesTypes4));
        System.assertEquals(emailAddressesTypes1.hashCode(), emailAddressesTypes2.hashCode());
        System.assertEquals(emailAddressesTypes3.hashCode(), emailAddressesTypes4.hashCode());
    }
}
