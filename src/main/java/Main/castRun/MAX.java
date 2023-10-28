package Main.castRun;


public class MAX {
    public  long max(long vaule1, long value2) throws CannotCastException {

        long returnvalue = 0;
        if (vaule1 >= value2) {
            returnvalue = vaule1;
        } else if (vaule1 < value2) {
            returnvalue = value2;
        } else {
            throw new CannotCastException("Casting Error!");
        }

        return returnvalue;
    }

    public long min(long vaule1, long value2) throws CannotCastException {

        long returnvalue = 0;
        if (vaule1 <= value2) {
            returnvalue = vaule1;
        } else if (value2 < vaule1) {
            returnvalue = value2;
        } else {
            throw new CannotCastException("Casting Error!");
        }

        return returnvalue;
    }

}
