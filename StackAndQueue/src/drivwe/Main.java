package drivwe;

public class Main {

	public static void main(String[] args) {
		System.out.println("Abstraction.");
		AbstractedStack stack = new AbstractedStack();
		System.out.println(stack.IsExpValid("(1 + 2 * (3 -1) ) / (1 + 1)"));
		System.out.println(stack.IsExpValid("(1 + 2 * (3 -1) / (1 + 1)"));
		InterfacedStack stack1 = new InterfacedStack();
		System.out.println(stack1.IsExpValid("(1 + 2 * (3 -1) ) / (1 + 1)"));
		System.out.println(stack1.IsExpValid("(1 + 2 * (3 -1) / (1 + 1)"));

	}

}
