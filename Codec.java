import java.util.ArrayDeque;
import java.util.Deque;

public class Codec {
    public static final class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static final class NodeSlot {
        private final TreeNode node;

        private NodeSlot(TreeNode node) {
            this.node = node;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder data = new StringBuilder();
        Deque<NodeSlot> pending = new ArrayDeque<>();
        pending.push(new NodeSlot(root));

        while (!pending.isEmpty()) {
            TreeNode node = pending.pop().node;
            if (data.length() > 0) {
                data.append(',');
            }
            if (node == null) {
                data.append("null");
                continue;
            }

            data.append(node.val);
            pending.push(new NodeSlot(node.right));
            pending.push(new NodeSlot(node.left));
        }

        return data.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Serialized tree must not be null or empty");
        }

        String[] tokens = data.split(",", -1);
        int[] index = {0};
        TreeNode root = build(tokens, index);
        if (index[0] != tokens.length) {
            throw new IllegalArgumentException("Serialized tree contains extra values");
        }
        return root;
    }

    private TreeNode build(String[] tokens, int[] index) {
        if (index[0] >= tokens.length) {
            throw new IllegalArgumentException("Serialized tree is incomplete");
        }

        String token = tokens[index[0]++];
        if ("null".equals(token)) {
            return null;
        }

        TreeNode node;
        try {
            node = new TreeNode(Integer.parseInt(token));
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("Invalid tree node value: " + token, exception);
        }
        node.left = build(tokens, index);
        node.right = build(tokens, index);
        return node;
    }
}
