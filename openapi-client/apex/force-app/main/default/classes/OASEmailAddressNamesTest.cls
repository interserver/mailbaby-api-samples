@isTest
private class OASEmailAddressNamesTest {
    @isTest
    private static void equalsSameInstance() {
        OASEmailAddressNames emailAddressNames1 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames2 = emailAddressNames1;
        OASEmailAddressNames emailAddressNames3 = new OASEmailAddressNames();
        OASEmailAddressNames emailAddressNames4 = emailAddressNames3;

        System.assert(emailAddressNames1.equals(emailAddressNames2));
        System.assert(emailAddressNames2.equals(emailAddressNames1));
        System.assert(emailAddressNames1.equals(emailAddressNames1));
        System.assert(emailAddressNames3.equals(emailAddressNames4));
        System.assert(emailAddressNames4.equals(emailAddressNames3));
        System.assert(emailAddressNames3.equals(emailAddressNames3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASEmailAddressNames emailAddressNames1 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames2 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames3 = new OASEmailAddressNames();
        OASEmailAddressNames emailAddressNames4 = new OASEmailAddressNames();

        System.assert(emailAddressNames1.equals(emailAddressNames2));
        System.assert(emailAddressNames2.equals(emailAddressNames1));
        System.assert(emailAddressNames3.equals(emailAddressNames4));
        System.assert(emailAddressNames4.equals(emailAddressNames3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASEmailAddressNames emailAddressNames1 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames2 = new OASEmailAddressNames();

        System.assertEquals(false, emailAddressNames1.equals('foo'));
        System.assertEquals(false, emailAddressNames2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASEmailAddressNames emailAddressNames1 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames2 = new OASEmailAddressNames();
        OASEmailAddressNames emailAddressNames3;

        System.assertEquals(false, emailAddressNames1.equals(emailAddressNames3));
        System.assertEquals(false, emailAddressNames2.equals(emailAddressNames3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASEmailAddressNames emailAddressNames1 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames2 = new OASEmailAddressNames();

        System.assertEquals(emailAddressNames1.hashCode(), emailAddressNames1.hashCode());
        System.assertEquals(emailAddressNames2.hashCode(), emailAddressNames2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASEmailAddressNames emailAddressNames1 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames2 = OASEmailAddressNames.getExample();
        OASEmailAddressNames emailAddressNames3 = new OASEmailAddressNames();
        OASEmailAddressNames emailAddressNames4 = new OASEmailAddressNames();

        System.assert(emailAddressNames1.equals(emailAddressNames2));
        System.assert(emailAddressNames3.equals(emailAddressNames4));
        System.assertEquals(emailAddressNames1.hashCode(), emailAddressNames2.hashCode());
        System.assertEquals(emailAddressNames3.hashCode(), emailAddressNames4.hashCode());
    }
}
