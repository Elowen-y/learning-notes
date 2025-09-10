# Git

## Git 概述

- 分布式版本控制 VS 集中式版本控制
- 工作区 -- git add --> 暂存区 -- git commit --> 本地库 -- 推送 --> 远程库（代码托管中心）
- 代码托管中心
  - 局域网：
    - GitLab
  - 互联网：
    - GitHub
    - Gitee



## Git 安装

官网下载最新版



## Git 常用命令

| 命令名称                             | 作用                             |
| ------------------------------------ | -------------------------------- |
| git config --global user.name 用户名 | 设置用户签名                     |
| git config --global user.email 邮箱  | 设置用户签名（可以不是真实邮箱） |
| git init                             | 初始化本地库                     |
| git status                           | 查看本地库状态                   |
| git add 文件名                       | 添加到暂存区                     |
| git commit -m “日志信息” 文件名      | 提交到本地库                     |
| git reflog                           | 查看历史记录                     |
| git log                              | 查看版本详细信息                 |
| git reset --hard 版本号              | 版本穿梭                         |
| vim 文件名                           | 修改文件                         |



### 基础的Linux当中的命令

```sh
pwd     # 显示当前所在的位置
cd      # 进入到指定的目录
ls      # 查看当前目录下的内容
mkdir   # 创建一个目录
touch   # 创建一个文件
clear   # 清屏命令或者用快捷键（ctrl+L）
```





## Git 分支操作

| 命令名称            | 作用                         |
| ------------------- | ---------------------------- |
| git branch 分支名   | 创建分支                     |
| git branch -v       | 查看分支                     |
| git checkout 分支名 | 切换分支                     |
| git merge 分支名    | 把指定的分支合并到当前分支上 |

**分支合并冲突解决**：

- 需要手动 `vim 文件名` 进行修改



git 分支底层其实是两个指针：

- 一个是 **HEAD**，指向的是具体的分支；（比如这个分支是 master）
- 一个是**具体的分支**（比如是 master）指向的是具体的版本。



## Git 团队协作机制

### 团队内协作

![](https://gitee.com/the-sherry/picture/raw/master/typora/202508252225826.png)

### 跨团队协作

![](https://gitee.com/the-sherry/picture/raw/master/typora/202508252234056.png)





## GitHub 操作

### 远程库操作

| 命令名称                           | 作用                                                       |
| ---------------------------------- | ---------------------------------------------------------- |
| git remote -v                      | 查看当前所有远程地址别名                                   |
| git remote add 别名 远程地址       | 起别名                                                     |
| git push 别名 分支                 | 推送本地分支上的内容到远程仓库                             |
| git clone 远程地址                 | 将远程仓库的内容克隆到本地                                 |
| git pull 远程库地址别名 远程分支名 | 将远程仓库对于分支最新内容拉下来后与当前本地分支直接合并   |
| git branch -M main                 | 将默认分支从 master 改为 main（强制重命名当前分支为 main） |

代码推送 Push

代码拉取 Pull



### 代码克隆 Clone

clone 会做如下操作：

1. 拉取代码
2. 初始化本地库
3. 创建别名



### SSH 免密登录

1. 找到当前用户的家目录
2. 删除 `.ssh` 目录
3. 右键 git bash
4. 输入命令 `ssh-keygen -t rsa -C 2160184679@qq.com`，回车三次
5. 进入 `.ssh` 目录下：`cd .ssh`
6. `ll` 查看目录下的内容，有两个：
   1. 公钥 `id_rsa.pub`
   2. 私钥 `id_rsa`
7. 查看公钥 `cat id_rsa.pub`
8. 复制公钥，打开 git 官网，settings 里的 SSH 将所复制的公钥添加上去
9. 即可使用 SSH





## Idea 集成 Git

### 配置 Git 忽略文件

1. 创建忽略规则文件 `git.ignore`（建议放在用户家目录下，即 C:\Users\Lenovo【作者本机】）

2. 在 `.gitconfig` 文件中引用忽略配置文件（在用户家目录下）

   ```
   [user]
   	name = Elowen
   	email = 2160184679@qq.com
   [core]
   	excludesfile = C:/Users/Lenovo/git.ignore
   注：这里使用的是正斜线“/”，不要使用反斜线“\”
   ```

   



## Idea 集成 GitHub

下载插件 GitHub



## 国内代码托管中心 - 码云

### 码云创建远程库



### Idea 集成 Gitee 码云

下载插件 Gitee，其余同 GitHub



### 码云连接 GitHub 进行代码的复制和迁移
