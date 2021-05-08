@isTest
private class OASMailContactTest {
    @isTest
    private static void equalsSameInstance() {
        OASMailContact mailContact1 = OASMailContact.getExample();
        OASMailContact mailContact2 = mailContact1;
        OASMailContact mailContact3 = new OASMailContact();
        OASMailContact mailContact4 = mailContact3;

        System.assert(mailContact1.equals(mailContact2));
        System.assert(mailContact2.equals(mailContact1));
        System.assert(mailContact1.equals(mailContact1));
        System.assert(mailContact3.equals(mailContact4));
        System.assert(mailContact4.equals(mailContact3));
        System.assert(mailContact3.equals(mailContact3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASMailContact mailContact1 = OASMailContact.getExample();
        OASMailContact mailContact2 = OASMailContact.getExample();
        OASMailContact mailContact3 = new OASMailContact();
        OASMailContact mailContact4 = new OASMailContact();

        System.assert(mailContact1.equals(mailContact2));
        System.assert(mailContact2.equals(mailContact1));
        System.assert(mailContact3.equals(mailContact4));
        System.assert(mailContact4.equals(mailContact3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASMailContact mailContact1 = OASMailContact.getExample();
        OASMailContact mailContact2 = new OASMailContact();

        System.assertEquals(false, mailContact1.equals('foo'));
        System.assertEquals(false, mailContact2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASMailContact mailContact1 = OASMailContact.getExample();
        OASMailContact mailContact2 = new OASMailContact();
        OASMailContact mailContact3;

        System.assertEquals(false, mailContact1.equals(mailContact3));
        System.assertEquals(false, mailContact2.equals(mailContact3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASMailContact mailContact1 = OASMailContact.getExample();
        OASMailContact mailContact2 = new OASMailContact();

        System.assertEquals(mailContact1.hashCode(), mailContact1.hashCode());
        System.assertEquals(mailContact2.hashCode(), mailContact2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASMailContact mailContact1 = OASMailContact.getExample();
        OASMailContact mailContact2 = OASMailContact.getExample();
        OASMailContact mailContact3 = new OASMailContact();
        OASMailContact mailContact4 = new OASMailContact();

        System.assert(mailContact1.equals(mailContact2));
        System.assert(mailContact3.equals(mailContact4));
        System.assertEquals(mailContact1.hashCode(), mailContact2.hashCode());
        System.assertEquals(mailContact3.hashCode(), mailContact4.hashCode());
    }
}
