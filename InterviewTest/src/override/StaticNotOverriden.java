package override;

public class StaticNotOverriden extends superClass{
	protected static void instanceMethod(){
	//protected void instanceMethod(){
		   System.out.println("I am in Superclas InstanceMethod");
	}
}

class superClass{
	protected static void instanceMethod(){
		   System.out.println("I am in Superclas InstanceMethod");
	}

}


/*
Remove comment, will see Compilation error :- overridden method is static
*/