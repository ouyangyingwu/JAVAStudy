package main.java.exception;

/*	自定义异常类
 *	
*/
public class IndexException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IndexException(){
        
    }
    public IndexException(String msg){
        super(msg);
    }

}
