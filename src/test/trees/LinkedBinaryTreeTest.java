package trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedBinaryTreeTest {

	LinkedBinaryTree<String> binaryTree;
	
	@Before
	public void setup(){
		binaryTree = new LinkedBinaryTree();
	}
	
	@Test
	public void testSizeInitialSize(){
		assertEquals("Initial size should be zero", 0, binaryTree.size());
		assertTrue("Initial binary tree should be empty", binaryTree.isEmpty());
	}
	
	@Test
	public void testAddRoot(){
		assertEquals("Starting with an empty tree we have a null root", null, binaryTree.root());
		binaryTree.addRoot("Root");
		assertEquals("Size should be equal to 1 now", 1, binaryTree.size());
		assertEquals("root should be equal to String Root", "Root", binaryTree.root().getElement());
	}
	
	public void testAddLeftAndAddRight(){
		
	}
}
