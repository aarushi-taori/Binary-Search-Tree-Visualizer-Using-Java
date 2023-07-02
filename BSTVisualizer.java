import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BSTVisualizer extends JFrame {
    private Node root;

    public BSTVisualizer() {
        setTitle("BST Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(2000, 800);
        setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        getContentPane().add(panel);

        DrawingPanel drawingPanel = new DrawingPanel();
        panel.add(drawingPanel, BorderLayout.CENTER);
        drawingPanel.setBackground(Color.lightGray);
        drawingPanel.setPreferredSize(new Dimension(2000, 800));

        JLabel headingLabel = new JLabel("<html><center>Binary Search Tree Visualizer</center></html>");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 30));
       drawingPanel.add(headingLabel);

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.lightGray);
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setLayout(new GridLayout(2, 3, 10, 10));
        controlPanel.setPreferredSize(new Dimension(1000, 180));

        JButton insertButton = new JButton("Insert Node");
        JButton deleteButton = new JButton("Delete Node");
        JButton clearButton = new JButton("Clear Tree");
        JButton inorderButton = new JButton("In-order Traversal");
        JButton preorderButton = new JButton("Pre-order Traversal");
        JButton postorderButton = new JButton("Post-order Traversal");

        controlPanel.add(insertButton);
        controlPanel.add(deleteButton);
        controlPanel.add(clearButton);
        controlPanel.add(inorderButton);
        controlPanel.add(preorderButton);
        controlPanel.add(postorderButton);

        panel.add(controlPanel, BorderLayout.SOUTH);

        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter a number:");
                try {
                    int value = Integer.parseInt(input);
                    insertNode(value);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Enter a number to delete:");
                try {
                    int value = Integer.parseInt(input);
                    deleteNode(value);
                    drawingPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearTree();
                drawingPanel.repaint();
            }
        });

        inorderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "In-order Traversal: " + inorderTraversal());
            }
        });

        preorderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Pre-order Traversal: " + preorderTraversal());
            }
        });

        postorderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Post-order Traversal: " + postorderTraversal());
            }
        });

        controlPanel.add(insertButton);
        controlPanel.add(deleteButton);
        controlPanel.add(clearButton);
        controlPanel.add(inorderButton);
        controlPanel.add(preorderButton);
        controlPanel.add(postorderButton);
        panel.add(controlPanel, BorderLayout.SOUTH);
    }

    private void insertNode(int value) {
        root = insertNodeRecursive(root, value);
    }

    private Node insertNodeRecursive(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insertNodeRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = insertNodeRecursive(root.right, value);
        }

        return root;
    }

    private void deleteNode(int value) {
        root = deleteNodeRecursive(root, value);
    }

    private Node deleteNodeRecursive(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.data) {
            root.left = deleteNodeRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNodeRecursive(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = findMinValue(root.right);
            root.right = deleteNodeRecursive(root.right, root.data);
        }

        return root;
    }

    private int findMinValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    private void clearTree() {
        root = null;
    }

    private String inorderTraversal() {
        StringBuilder result = new StringBuilder();
        inorderTraversalRecursive(root, result);
        return result.toString().trim();
    }

    private void inorderTraversalRecursive(Node root, StringBuilder result) {
        if (root != null) {
            inorderTraversalRecursive(root.left, result);
            result.append(root.data).append(" , ");
            inorderTraversalRecursive(root.right, result);
        }
    }

    private String preorderTraversal() {
        StringBuilder result = new StringBuilder();
        preorderTraversalRecursive(root, result);
        return result.toString().trim();
    }

    private void preorderTraversalRecursive(Node root, StringBuilder result) {
        if (root != null) {
            result.append(root.data).append(" , ");
            preorderTraversalRecursive(root.left, result);
            preorderTraversalRecursive(root.right, result);
        }
    }

    private String postorderTraversal() {
        StringBuilder result = new StringBuilder();
        postorderTraversalRecursive(root, result);
        return result.toString().trim();
    }

    private void postorderTraversalRecursive(Node root, StringBuilder result) {
        if (root != null) {
            postorderTraversalRecursive(root.left, result);
            postorderTraversalRecursive(root.right, result);
            result.append(root.data).append(" , ");
        }
    }

    class DrawingPanel extends JPanel {
        private static final int RADIUS = 20;
        private static final int HORIZONTAL_SPACE = 40;
        private static final int VERTICAL_SPACE = 60;
        private int startX;
        private int startY;

        public DrawingPanel() {
            setPreferredSize(new Dimension(2000, 700));
            startX = 750;
            startY = 100;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawTree(g, root, startX, startY, getWidth() / 2);
        }

        private void drawTree(Graphics g, Node root, int x, int y, int horizontalSpace) {
            if (root == null) {
                return;
            }

            g.setColor(Color.black);
            g.fillOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
            g.setColor(Color.white);
            g.drawString(String.valueOf(root.data), x - 5, y + 5);

            if (root.left != null) {
                g.setColor(Color.gray);
                g.drawLine(x, y + RADIUS, x - horizontalSpace/4, y + VERTICAL_SPACE);
                drawTree(g, root.left, x - horizontalSpace/4, y + VERTICAL_SPACE, horizontalSpace / 2);
            }

            if (root.right != null) {
                g.setColor(Color.gray);
                g.drawLine(x, y + RADIUS, x + horizontalSpace/4, y + VERTICAL_SPACE);
                drawTree(g, root.right, x + horizontalSpace/4, y + VERTICAL_SPACE, horizontalSpace / 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BSTVisualizer visualizer = new BSTVisualizer();
                visualizer.setVisible(true);
            }
        });
    }
}

