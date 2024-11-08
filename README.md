# Zero-gRPC
Zero-gRPC
# 1. 概述
## 1.1. 简介
Protobuf（Protocol Buffers）是由 Google 开发的一种轻量级、高效的数据交换格式，它被用于结构化数据的序列化、反序列化和传输。相比于 XML 和 JSON 等文本格式，
Protobuf 具有更小的数据体积、更快的解析速度和更强的可扩展性。 Protobuf 的核心思想是使用协议（Protocol）来定义数据的结构和编码方式。使用 Protobuf，
可以先定义数据的结构和各字段的类型、字段等信息，然后使用 Protobuf 提供的编译器生成对应的代码，用于序列化和反序列化数据。
由于 Protobuf 是基于二进制编码的，因此可以在数据传输和存储中实现更高效的数据交换，同时也可以跨语言使用。
## 1.2. 特点
1. 更小的数据量：Protobuf 的二进制编码通常只有 XML 和 JSON 的 1/3 到 1/10 左右，因此在网络传输和存储数据时可以节省带宽和存储空间。 
2. 更快的序列化和反序列化速度：由于 Protobuf 使用二进制格式，所以序列化和反序列化速度比 XML 和 JSON 快得多。
3. 跨语言：Protobuf 支持多种编程语言，可以使用不同的编程语言来编写客户端和服务端。这种跨语言的特性使得 Protobuf 受到很多开发者的欢迎（JSON 也是如此）。
4. 易于维护可扩展：Protobuf 使用 .proto 文件定义数据模型和数据格式，这种文件比 XML 和 JSON 更容易阅读和维护，且可以在不破坏原有协议的基础上，轻松添加或删除字段，实现版本升级和兼容性。
# 2. 功能

# 3. 使用
## 3.1. 头部全局定义
- syntax = "proto3"; 指定 Protobuf 版本为版本 3（最新版本） 
- package com.wdbyte.protobuf; 指定 Protobuf 包名，防止有相同类名的 message 定义，这个包名是生成的类中所用到的一些信息的前缀，并非类所在包。 
- option java_multiple_files = true; 是否生成多个文件。若 false，则只会生成一个类，其他类以内部类形式提供。 
- option java_package = 生成的类所在包。 
- option java_outer_classname 生成的类名，若无，自动使用文件名进行驼峰转换来为类命名。
## 3.2. 消息结构具体定义
message Person 定一个了一个 Person 类。 Person 类中的字段被 optional 修饰，被 optional 修饰说明字段可以不赋值。
- 修饰符 optional 表示可选字段，可以不赋值。 
- 修饰符 repeated 表示数据重复多个，如数组，如 List。 
- 修饰符 required 表示必要字段，必须给值，否则会报错 RuntimeException，但是在 Protobuf 版本 3 中被移除。即使在版本 2 中也应该慎用，因为一旦定义，很难更改。
## 3.3.字段类型定义
修饰符后面紧跟的是字段类型，如 int32 、string。常用的类型如下：
- int32、int64、uint32、uint64：整数类型，包括有符号和无符号类型。
- float、double：浮点数类型。 
- bool：布尔类型，只有两个值，true 和 false。 
- string：字符串类型。 
- bytes：二进制数据类型。 
- enum：枚举类型，枚举值可以是整数或字符串。 
- message：消息类型，可以嵌套其他消息类型，类似于结构体。
>字段后面的 =1，=2 是作为序列化后的二进制编码中的字段的对应标签，因为 Protobuf 消息在序列化后是不包含字段信息的，只有对应的字段序号，所以节省了空间。
> 也因此，1-15 比 16 会少一个字节，所以尽量使用 1-15 来指定常用字段。且一旦定义，不要随意更改，否则可能会对不上序列化信息。

# 4. 其他

# 5. 参考