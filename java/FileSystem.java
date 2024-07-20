import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private Map<String, Integer> pathMap;

    public FileSystem() {
        pathMap = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (path == null || path.length() < 2 || path.charAt(0) != '/' || pathMap.containsKey(path)) {
            return false;
        }

        // 부모 경로 확인
        int lastSlashIndex = path.lastIndexOf('/');
        if (lastSlashIndex > 0) {
            String parentPath = path.substring(0, lastSlashIndex);
            if (!parentPath.equals("/") && !pathMap.containsKey(parentPath)) {
                return false;
            }
        }

        pathMap.put(path, value);
        return true;
    }

    public int get(String path) {
        return pathMap.getOrDefault(path, -1);
    }

    public static void main(String[] args) {
        // 예제 1
        FileSystem fileSystem1 = new FileSystem();
        System.out.println(fileSystem1.createPath("/a", 1)); // 출력: true
        System.out.println(fileSystem1.get("/a")); // 출력: 1

        // 예제 2
        FileSystem fileSystem2 = new FileSystem();
        System.out.println(fileSystem2.createPath("/leet", 1)); // 출력: true
        System.out.println(fileSystem2.createPath("/leet/code", 2)); // 출력: true
        System.out.println(fileSystem2.get("/leet/code")); // 출력: 2
        System.out.println(fileSystem2.createPath("/c/d", 1)); // 출력: false
        System.out.println(fileSystem2.get("/c")); // 출력: -1

        // 예제 3
        FileSystem fileSystem3 = new FileSystem();
        System.out.println(fileSystem3.createPath("/foo", 5)); // 출력: true
        System.out.println(fileSystem3.createPath("/foo/bar", 10)); // 출력: true
        System.out.println(fileSystem3.get("/foo")); // 출력: 5
        System.out.println(fileSystem3.get("/foo/bar")); // 출력: 10
        System.out.println(fileSystem3.get("/foo/baz")); // 출력: -1

        // 예제 4
        FileSystem fileSystem4 = new FileSystem();
        System.out.println(fileSystem4.createPath("/x", 100)); // 출력: true
        System.out.println(fileSystem4.createPath("/x/y", 200)); // 출력: true
        System.out.println(fileSystem4.createPath("/x/y/z", 300)); // 출력: true
        System.out.println(fileSystem4.get("/x/y")); // 출력: 200
        System.out.println(fileSystem4.createPath("/a/b", 400)); // 출력: false

        // 예제 5
        FileSystem fileSystem5 = new FileSystem();
        System.out.println(fileSystem5.createPath("/apple", 123)); // 출력: true
        System.out.println(fileSystem5.createPath("/apple/orange", 456)); // 출력: true
        System.out.println(fileSystem5.get("/apple")); // 출력: 123
        System.out.println(fileSystem5.get("/apple/orange")); // 출력: 456
        System.out.println(fileSystem5.createPath("/apple/orange", 789)); // 출력: false (이미 존재하는 경로)

    }
}
