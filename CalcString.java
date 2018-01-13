import java.util.StringTokenizer;

public class CalcString {
	String input;


	public CalcString() {
		input = null;
	} 
	public CalcString(String str) {
		input =  0+str;
	}
	
	public void SetInput (String str) {
		input = str;
	}
	
	public boolean ifStackNeedsPop (String peak, String cc) {
		String highLevel = "*/";
		String lowLevel = "+-" ;
		if (highLevel.contains(peak)&&highLevel.contains(cc)) {
			return true;
		} else if (lowLevel.contains(peak)&&lowLevel.contains(cc)) {
			return true;
		} else if (highLevel.contains(peak)&&lowLevel.contains(cc)) {
			return true;
		}
			
		return false;
	}
	
	public String evaluation() {

		StringTokenizer st = new StringTokenizer(input,"+-*/",true);
		
		String cc; //current char
		int r = 0; 
		//initializing 
		String marks = "+-*/";
		String higherMarks = "*/";
		String lowerMarks = "+-";
		Queue<String> valueQueue = new Queue<String>();
		Stack operatorStack =  new Stack();

		/*
		Checking each char of the st, until it has no more char. If it's a integer,
		pop it into a valueQueue. If it is an operator, pop it onto the operator
		stack and then do a ifStackNeedsPop check. Poping the top of the stack
		to the valueQueue if ifStackNeedsPop return a true.
		*/
		while (st.hasMoreTokens()) {
			cc = st.nextToken();

			if(marks.contains(cc)) {
				//stack it to operator stack

				if (ifStackNeedsPop(operatorStack.peak(),cc)){
					while (ifStackNeedsPop(operatorStack.peak(),cc)) {
						valueQueue.enqueue(operatorStack.pop());
					}
					operatorStack.push(cc);			
				}
				else {
					operatorStack.push(cc);
					
				}
			} else {
				valueQueue.enqueue(cc); 
				
			}
		}


		Stack resultStack = new Stack(); //creating a result stack storing output
		
		//Calculating the postfix result
		
		while (!operatorStack.isEmpty()) {
			valueQueue.enqueue(operatorStack.pop());
		}
		
		/*
		 * go through the valueQueue until there is no item left
		 * if it is a number, stack it on top of the result stack
		 * if it's an operator, pop first two of the valueStack, and do an evaluation accordingly
		 * push the result of the evaluation on the result the stack
		 * 
		 * */
		while (!valueQueue.isEmpty()) {
			if (marks.contains(valueQueue.peak())) { //if the first item of the valueQueue is an operator 
				double rightNumber = Double.parseDouble(resultStack.pop());
				double leftNumber = Double.parseDouble(resultStack.pop());
				switch (valueQueue.dequeue()) {
				case "+" : resultStack.push(Double.toString(leftNumber + rightNumber));
				break;
				case "-" : resultStack.push(Double.toString(leftNumber - rightNumber));
				break;
				case "*" : resultStack.push(Double.toString(leftNumber * rightNumber));
				break;
				case "/" : resultStack.push(Double.toString(leftNumber / rightNumber));
				break;
				}
			} else  { // if the first item of the valueQueue is Integer
				resultStack.push(valueQueue.dequeue());
			}
		}
		
		//print the calculated result, which should be one last item left in the valueStack
		return resultStack.peak();
		
	}
	
	public String getOutput () {
		return evaluation();
	}
}
