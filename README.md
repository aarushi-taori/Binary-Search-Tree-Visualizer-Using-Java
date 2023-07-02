# Binary Search Tree Visualizer

This is a Java program that provides a visual representation of a Binary Search Tree (BST). The program utilizes the Java Swing library and JFrame to create a graphical user interface for the BST visualization.

## Getting Started

To run the BST Visualizer, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Copy the provided code into a Java source file (e.g., `BSTVisualizer.java`).
3. Compile the source file using the following command:
   ```
   javac BSTVisualizer.java
   ```
4. Run the compiled program with the following command:
   ```
   java BSTVisualizer
   ```

## Usage

Upon running the program, the BST Visualizer window will appear, allowing you to interact with the BST and perform various operations. The following features are available:

- **Insert Node**: Click the "Insert Node" button to add a new node to the BST. A dialog box will prompt you to enter a number, which will be inserted as a node into the BST.
- **Delete Node**: Click the "Delete Node" button to remove a specific node from the BST. A dialog box will prompt you to enter the number of the node you wish to delete.
- **Clear Tree**: Click the "Clear Tree" button to remove all nodes from the BST, resulting in an empty tree.
- **In-order Traversal**: Click the "In-order Traversal" button to display the in-order traversal of the BST in a message box.
- **Pre-order Traversal**: Click the "Pre-order Traversal" button to display the pre-order traversal of the BST in a message box.
- **Post-order Traversal**: Click the "Post-order Traversal" button to display the post-order traversal of the BST in a message box.

## Visual Representation

The BST Visualizer renders the BST as a graphical tree structure, where each node is represented as a filled circle. The numbers associated with the nodes are displayed inside the corresponding circles. The left and right child relationships between nodes are represented by lines connecting the parent node with its children. The BST Visualizer utilizes JFrame and AWT to render the BST as a graphical tree structure. The visual representation includes the following elements:

**JFrame:** The main application window for the BST Visualizer.
**JPanel:** A panel where the BST is drawn using the AWT Graphics class.
**DrawingPanel:** An inner class extending JPanel that handles the drawing of the BST.
**Graphics:** The AWT Graphics class is used to draw the nodes and connections of the BST.

## Notes

- The program provides a basic graphical interface for visualizing the operations on a BST. It is designed to facilitate understanding and learning rather than focusing on performance or advanced functionality.
- The graphical representation of the BST is limited to a two-dimensional layout and may not accurately depict the actual structure of a larger or more complex tree.

