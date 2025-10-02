# DynamicClassLoader

**DynamicClassLoader** is an open-source Java project demonstrating how to **load classes dynamically from JAR files** — whether hosted locally or on a remote server.  

This project provides **working example code** for runtime class loading, useful for plugin systems, modular applications, or learning Java’s `URLClassLoader`.

---

## Features

- Load classes from **local JAR files**  
- Load classes from **remote URLs**  
- Instantiate and invoke methods at runtime  
- Lightweight and framework-free  
- Open for reuse and adaptation  

---

## Getting Started

### Prerequisites
- **Java 8+**

### Clone
```bash
git clone https://github.com/prasanna0586/DynamicClassLoader.git
cd DynamicClassLoader
```

Compile with your IDE or `javac`.

---

## Example Usage

```java
// Load a JAR file (local)
URL jarUrl = new File("/path/to/my-module.jar").toURI().toURL();
DynamicClassLoader loader = new DynamicClassLoader(new URL[]{ jarUrl }, ClassLoader.getSystemClassLoader());

// Load class
Class<?> clazz = loader.loadClass("com.example.MyPlugin");

// Instantiate and run
Object plugin = clazz.getDeclaredConstructor().newInstance();
Method method = clazz.getMethod("execute");
method.invoke(plugin);
```

For remote JARs:

```java
URL jarUrl = new URL("http://myserver.com/modules/plugin.jar");
DynamicClassLoader loader = new DynamicClassLoader(new URL[]{ jarUrl }, getClass().getClassLoader());
```

---

## Project Philosophy

- **Direct**: Shows how runtime loading works with clear, working code  
- **Adaptable**: Easy to modify for plugin frameworks or custom loaders  
- **Transparent**: Minimal abstraction — built directly on Java’s `URLClassLoader`  
- **Open**: Shared for anyone to learn from, experiment with, or extend  

---

## Potential Extensions

- Dependency resolution for multiple JARs  
- Reload/unload modules dynamically  
- Secure sandboxing for plugins  
- Integration with modern Java module systems  

---

## Historical Note

This project was originally created many years ago and has remained publicly available since then.  
It continues to serve as a simple, accessible reference for developers exploring runtime class loading in Java.

---

## License

Released under the **MIT License**. Free to use, adapt, and distribute.
