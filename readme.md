# 情報システム応用演習課題
# BlackJack

**本アプリケーションはjava11を利用できる環境で動作します．**

最終更新日 2023/1/10

---

## セットアップマニュアル

**※必ずお読みください．アプリケーションが正常に動作しません．**

本アプリケーションはSpring bootを利用したWebアプリケーションです．そのため，事前に<font color="Red">java11およびJDKのダウンロード</font>と<font color="Red">タイムゾーンの設定</font>を行ってください．


### ◇アプリケーションのダウンロード方法，実行・停止方法

#### ダウンロード方法
ダウンロードにはgitの機能を利用します．そのため，まず以下のコマンドを実行してgitをダウンロードしてください．

```
$ sudo apt-get install git-all
```

gitをダウンロードした状態でサーバのコマンドラインで以下のコマンドを実行すると本アプリケーションをダウンロードできます．フォルダは好きなところで問題ありませんが，ここでは[```~/```]に展開する想定で説明を行います．


```
$ cd
$ git clone https://github.com/take0x/blackjack.git
$ chmod -R 755 blackjack
```

上記のコマンドを実行すると```~/blackjack/```というディレクトリが作成され，ディレクトリ内が以下のようになっていれば問題ありません．

```
$ ls -al
total 17
drwxr-xr-x 5 isdev22 isdev22   10 Jan 10 16:12 .
drwxrwxr-x 3 isdev22 isdev22    3 Jan 10 16:12 ..
drwxr-xr-x 8 isdev22 isdev22   13 Jan 10 16:12 .git
-rwxr-xr-x 1 isdev22 isdev22  444 Jan 10 16:12 .gitignore
-rwxr-xr-x 1 isdev22 isdev22  844 Jan 10 16:12 build.gradle
drwxr-xr-x 3 isdev22 isdev22    3 Jan 10 16:12 gradle
-rwxr-xr-x 1 isdev22 isdev22 8188 Jan 10 16:12 gradlew
-rwxr-xr-x 1 isdev22 isdev22 2838 Jan 10 16:12 gradlew.bat
-rwxr-xr-x 1 isdev22 isdev22   31 Jan 10 16:12 settings.gradle
drwxr-xr-x 4 isdev22 isdev22    4 Jan 10 16:12 src
```

配布するアプリケーションはアップデートされる場合があり，その場合は以下のコマンドでモジュールをアップデートすることができます．ダウンロードした個所が「```~/```」であった場合は

``` sh
cd ~/
git pull
```

とするとアップデートする事が可能です．ただし，配布するプログラムやファイルを編集するとアップデートできない場合があります．

#### 実行方法

アプリケーションをはじめて実行する際には以下のコマンドを実行してください．

```
$ bash ./gradlew
```

結果がこのようになれば，正常にgradleがダウンロードされています．

```
> Task :help

Welcome to Gradle 7.5.1.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see more detail about a task, run gradlew help --task <task>

To see a list of command-line options, run gradlew --help

For more detail on using Gradle, see https://docs.gradle.org/7.5.1/userguide/command_line_interface.html

For troubleshooting, visit https://help.gradle.org
```

アプリケーションの実行は以下のコマンドで行います．

```
$ bash ./gradlew bootrun
```

以下は参考の実行結果です．

```
> Task :bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.5)

2023-01-10 16:18:54.326  INFO 103484 --- [           main]
```

#### 停止方法
プログラムを停止する際には【Ctrl + C】`で強制終了できます．

---

## ユーザマニュアル
