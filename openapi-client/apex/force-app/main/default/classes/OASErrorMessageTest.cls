@isTest
private class OASErrorMessageTest {
    @isTest
    private static void equalsSameInstance() {
        OASErrorMessage errorMessage1 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage2 = errorMessage1;
        OASErrorMessage errorMessage3 = new OASErrorMessage();
        OASErrorMessage errorMessage4 = errorMessage3;

        System.assert(errorMessage1.equals(errorMessage2));
        System.assert(errorMessage2.equals(errorMessage1));
        System.assert(errorMessage1.equals(errorMessage1));
        System.assert(errorMessage3.equals(errorMessage4));
        System.assert(errorMessage4.equals(errorMessage3));
        System.assert(errorMessage3.equals(errorMessage3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASErrorMessage errorMessage1 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage2 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage3 = new OASErrorMessage();
        OASErrorMessage errorMessage4 = new OASErrorMessage();

        System.assert(errorMessage1.equals(errorMessage2));
        System.assert(errorMessage2.equals(errorMessage1));
        System.assert(errorMessage3.equals(errorMessage4));
        System.assert(errorMessage4.equals(errorMessage3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASErrorMessage errorMessage1 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage2 = new OASErrorMessage();

        System.assertEquals(false, errorMessage1.equals('foo'));
        System.assertEquals(false, errorMessage2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASErrorMessage errorMessage1 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage2 = new OASErrorMessage();
        OASErrorMessage errorMessage3;

        System.assertEquals(false, errorMessage1.equals(errorMessage3));
        System.assertEquals(false, errorMessage2.equals(errorMessage3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASErrorMessage errorMessage1 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage2 = new OASErrorMessage();

        System.assertEquals(errorMessage1.hashCode(), errorMessage1.hashCode());
        System.assertEquals(errorMessage2.hashCode(), errorMessage2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASErrorMessage errorMessage1 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage2 = OASErrorMessage.getExample();
        OASErrorMessage errorMessage3 = new OASErrorMessage();
        OASErrorMessage errorMessage4 = new OASErrorMessage();

        System.assert(errorMessage1.equals(errorMessage2));
        System.assert(errorMessage3.equals(errorMessage4));
        System.assertEquals(errorMessage1.hashCode(), errorMessage2.hashCode());
        System.assertEquals(errorMessage3.hashCode(), errorMessage4.hashCode());
    }
}
