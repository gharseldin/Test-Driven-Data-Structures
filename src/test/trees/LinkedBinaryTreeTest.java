package trees;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ListIterators.Position;

public class LinkedBinaryTreeTest {

	LinkedBinaryTree<String> binaryTree;
	
	@Before
	public void setup(){
		binaryTree = new LinkedBinaryTree();
	}
	
	private void initializeTree(LinkedBinaryTree<String> tree){
		Position<String> head = tree.addRoot("Top");
		Position<String> firstLeft = tree.addLeft(head, "Top->Left");
		Position<String> firstRight = tree.addRight(head, "Top->Right");
		tree.addLeft(firstLeft, "Top->Left->Left");
		tree.addRight(firstLeft, "Top->Left->Right");
		tree.addLeft(firstRight, "Top->Right->Left");
		//size should be 6
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
	
	@Test
	public void testAddLeftAndAddRight(){
		assertEquals("Strarting with an empty tree", 0, binaryTree.size());
		Position<String> head = binaryTree.addRoot("CEO");
		Position<String> assist1 = binaryTree.addLeft(head, "assistant CEO 1");
		Position<String> assist2 = binaryTree.addRight(head, "assistant CEO 2");
		assertEquals("The size is now 3", 3, binaryTree.size());
		assertEquals("left assistant = assistant CEO 1", "assistant CEO 1", binaryTree.left(head).getElement());
		assertEquals("right assistant = assistant CEO 2", "assistant CEO 2", binaryTree.right(head).getElement());
	}
	
	@Test
	public void testIsInternal(){
		initializeTree(binaryTree);
		Position<String> root = binaryTree.root();
		assertTrue("The root should be an internal node", binaryTree.isInternal(root));
		Position<String> firstLeft = binaryTree.left(root);
		assertTrue("This is an internal node", binaryTree.isInternal(firstLeft));
		Position<String> LeftOfFirstLeft = binaryTree.left(firstLeft);
		assertFalse("This is an external node", binaryTree.isInternal(LeftOfFirstLeft));
	}
}
