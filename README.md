==============================================================================================================================================
							AOP - ASPECT ORIENTED PROGRAMMING
							---------------------------------
1. AOP - Aspect Oriented Programming.
Few things about AOP - 






2. Pointcut Expression Language
	-> "execution(modifiers-pattern? return-type-pattern declaring-type-pattern? method-name-pattern(param-pattern) throws-pattern?)"
	-> Spring AOP only supports public or * as modifiers-pattern.
	-> return-type-pattern supports void, boolean, String, List<Customer>, etc.
	-> declaring-type-pattern is basically the class name.
	-> method-name-pattern is the method name to match.
	-> param-pattern is the parameter types to match.
	-> throws-pattern is the exception types to match.
	-> If the pattern has a question mark (?) means the pattern is optional. So modifiers-pattern, declaring-type-pattern, and throws-pattern
	are optional.
	-> Patterns can also use wildcards.
		-> Wildcard - *, means matches on everything.
	-> Pointcut Expressions Examples - 
		-> Match only addAcount() method in AccountDAO class.
		Answer: @Before("execution(public void com.arnab.aopdemo.dao.AccountDAO.addAccount())")
		-> Match any addAccount() method in any class.
		Answer: @Before("execution(public void addAccount())")
		-> Match methods starting with add in any class.
		Answer: @Before("execution(public void add*())")
		-> Using wildcards on modifier and return type.
		Answer: @Before("execution(* * processCreditCard*())")
		-> As the modifier is optional, you can rewrite the above expression as below.
		Answer: @Before("execution(* processCreditCard*())")
	-> Parameter wildcards - 
		-> () - matches a method with no-argument.
		-> (*) - matches a method with one argument of any type.
		-> (..) - matches a method with 0 or more arguments of any type.
	-> Pointcut Expressions Examples with Parameter Types - 
		-> Match addAccount() methods with no arguments.
		Answer: @Before("execution(* addAccount())")
		-> Match addAccount() methods that has Account parameter.
		Answer: @Before("execution(* addAccount(com.somebank.retail.Account))")
		-> Match addAccount() methods with any number of arguments.
		Answer: @Before("execution(* addAccount(..))")
		-> Match any method in our DAO package - "com.somebank.retail.dao".
		Answer: @Before("execution(* com.somebank.retail.dao.*.*(..))")

3. How to control the order of Advices being applied?
	MyLoggingDemoAspect - 3 Advices in this Aspect.
	-> beforeAddAccountAdvice.
	-> performApiAnalyticsAdvice.
	-> logToCloudAdvice.
	The order is actually undefined. Spring will pick one-by-one randomly and will execute.
	To control order -
		-> Refactor: Place Advices in separate Aspects.
		-> Control order on Aspects using the @Order annotation - @Order(1) means first.


4. JoinPoints
	-> When we are in an Aspect (i.e., for logging), how can we access method parameters?
	-> Example - theAccountDAO.addAccount(myAccount, true); --> I want to log these parameters with AOP.
	-> Development Process - 
		-> Access and display Method Signature.
			-> @Before("...")
			   public void beforeAddAccountAdvice(JoinPoint joinPoint) {  // Here JoinPoint has the metadata about method call.
			   		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			   		System.out.prinln("Method Signature: " + methodsSignature);
			   }
		-> Access and display Method Arguments.
			-> @Before("...")
			   public void beforeAddAccountAdvice(JoinPoint joinPoint) {
			   		Object[] args = joinPoint.getArgs();
			   		for(Object object: args) {
			   			System.out.println("Argument: " + object);
			   		}
			   }
==============================================================================================================================================

	
	
	