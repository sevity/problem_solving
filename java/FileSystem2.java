import java.util.*;

class FileSystem2 {
    class FNode {
        Map<String, FNode> path = new HashMap<>();  // 이걸 통해 트리구조를 이룬다.
        String content = "";
        boolean dir = true;
        String name;
    }

    private FNode root;

    public FileSystem2() {
        root = new FNode();
    }

    public List<String> ls(String path) {
        FNode node = getNode(path);
        if (!node.dir) {
            return Collections.singletonList(node.name);//이렇게 안하고 그냥 List<String> 만들어서 add()한다음에 리턴해도 됨.
        }
        List<String> result = new ArrayList<>(node.path.keySet());
        Collections.sort(result);
        return result;
    }

    public void mkdir(String path) {
        getNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        FNode fileNode = getNode(filePath);
        fileNode.dir = false;
        fileNode.content += content;
    }

    public String readContentFromFile(String filePath) {
        return getNode(filePath).content;
    }

    private FNode getNode(String path) {
        String[] parts = path.split("/");
        FNode node = root;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            node.path.putIfAbsent(part, new FNode());
            node = node.path.get(part);
            node.name = part;
        }
        return node;
    }

    public static void main(String[] args) {
        FileSystem2 fs = new FileSystem2();

        // 테스트 케이스 1
        fs.mkdir("/a/b/c");
        System.out.println(fs.ls("/a/b")); // 출력: [c]

        // 테스트 케이스 2
        fs.addContentToFile("/file.txt", "Hello, World!");
        System.out.println(fs.readContentFromFile("/file.txt")); // 출력: Hello, World!

        // 테스트 케이스 3
        fs.mkdir("/x/y/z");
        fs.addContentToFile("/x/y/z/file.txt", "Test");
        System.out.println(fs.ls("/x/y/z")); // 출력: [file.txt]

        // 테스트 케이스 4
        fs.addContentToFile("/file.txt", " Append");
        System.out.println(fs.readContentFromFile("/file.txt")); // 출력: Hello, World! Append

        // 테스트 케이스 5
        System.out.println(fs.ls("/file.txt")); // 출력: [file.txt]

        // 테스트 케이스 6: 디렉터리 내에 여러 파일 및 하위 디렉터리
        fs.mkdir("/dir");
        fs.addContentToFile("/dir/file1.txt", "File 1");
        fs.addContentToFile("/dir/file2.txt", "File 2");
        fs.mkdir("/dir/subdir");
        System.out.println(fs.ls("/dir")); // 출력: [file1.txt, file2.txt, subdir]        
    }
}
