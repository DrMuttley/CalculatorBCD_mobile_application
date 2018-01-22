package pl.polsl.java.lab5.model;

/**
 * The exception class that is generated when methods addition or subtraction
 * receive wrong input data:
 * - input number (string type) contains digits other than 0 and 1
 * - input number contains tetrad greater than permitted (max value: 1001)
 * - input number isn't a multiple of 4
 *
 * @author Lukasz Nowak
 * @version 5.0
 */
public class ModelException extends Exception {

    /** Constructor without parametric */
    public ModelException() {
    }

    /** Constructor
     *	@param message display message
     */
    public ModelException(String message) {
        super(message);
    }
}
