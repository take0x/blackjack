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

### 目次
##### 0．[初めに](#anchor0)
##### 1．[トップ画面](#anchor1)
##### 2．[ルール説明画面](#anchor2)
##### 3．[ログイン画面](#anchor3)
##### 4．[ホーム画面](#anchor4)
##### 5．[ロビー画面](#anchor5)
##### 6．[ゲーム画面](#anchor6)
##### 7．[結果表示画面](#anchor7)
##### 8．[マイニング画面](#anchor8)
##### 9．[管理者画面](#anchor9)

---

<a id="anchor0"></a>

#### ０．はじめに

<font color="Red">このアプリケーションを利用する時はブラウザに備わっているbackボタン(左上の戻るボタン)は使用しないでください．</font>予期せぬ動作をする場合があります．


<a id="anchor1"></a>

#### １．トップ画面

![top](https://user-images.githubusercontent.com/106970558/212520720-5c5a5cf7-d0c2-4df3-959e-b61365e158a1.png)

このページでは以下の機能があります．

|  ボタン名  |  機能  |
| :--- | :--- |
|  ログイン  |  ログイン画面に遷移します．  |
|  ルール  |  ルール説明画面へ遷移します．(ログイン無し閲覧できます．)  |


<a id="anchor2"></a>

#### ２．ルール説明画面

![rule](https://user-images.githubusercontent.com/106970558/212520719-328afd4e-74e0-4d21-8702-ca7bb888ef1e.png)

このページではブラックジャックのルール説明を書いています．


<a id="anchor3"></a>

#### ３．ログイン画面

![login](https://user-images.githubusercontent.com/106970558/212520726-0b5cf1fd-cacf-46c2-9eae-0b0e58f6a392.png)

このページは以下の機能があります．

|  空欄  |  入力  |
| :--- | :--- |
|  Username  |  利用するユーザ名を入力してください．  |
|  Password  |  パスワードを入力してください．  |

|  ボタン名  |  機能  |
| :--- | :--- |
|  Sign in  |  入力したユーザでログインしホーム画面へ遷移します．  |



<a id="anchor4"></a>

#### ４．ホーム画面

![home-admin](https://user-images.githubusercontent.com/106970558/212520723-194f317b-69dd-4b0a-b731-816b5aef8e33.png)

このページは以下の機能があります．

|  ボタン名  |  機能  |
| :--- | :--- |
|  入室  |  ロビー画面へ遷移します．  |
|  ルール  |  ルール説明画面へ遷移します．  |
|  マイニング  |  マイニング画面へ遷移します．  |
|  ログアウト  |  ログアウトし，トップ画面へ遷移します．  |
|  管理画面  |  管理画面へ遷移します．（＊管理者のみ表示されます．）  |


<a id="anchor5"></a>

#### ５．ロビー画面

![lobby](https://user-images.githubusercontent.com/106970558/212520725-6438365a-4691-4e30-994e-23458b1359b1.png)

このページは以下の機能があります．

|  空欄  |  入力  |
| :--- | :--- |
|  ベット額を入力  |  賭けたいコインの枚数を入力してください．  |
＊ベットするコインの枚数が所持コインの枚数より多い場合は自動的に0枚ベットしたものとして処理されます．

|  ボタン名  |  機能  |
| :--- | :--- |
|  退室  |  退室しロビー画面へ遷移します．  |
|  ゲームスタート  |  入力したコインの枚数を賭けてゲームを開始します．  |


<a id="anchor6"></a>

#### ６．ゲーム画面

![game](https://user-images.githubusercontent.com/106970558/212520722-e1f5ddc4-8344-408e-978d-7d2d45e821a2.png)

このページは以下の機能があります．

|  ボタン名  |  機能  |
| :--- | :--- |
|  ヒット  |  ヒットしカードを1枚引きます．  |
|  スタンド  |  スタンドし現在の手札で勝負します．  |


<a id="anchor7"></a>

#### ７．結果表示画面

![result](https://user-images.githubusercontent.com/106970558/212520718-295529e6-933e-4b3d-8ff4-eb5251721966.png)

このページはでは以下の機能があります．

|  ボタン名  |  機能  |
| :--- | :--- |
|  再戦  |  ロビー画面へ遷移します．  |
|  退室  |  退室し，ホーム画面へ遷移します．  |


<a id="anchor8"></a>

#### ８．マイニング画面

![mining](https://user-images.githubusercontent.com/106970558/212520727-f424e767-319b-40eb-b8a4-6e63e15a0658.png)

このページは以下の機能があります．

|  ボタン名  |  機能  |
| :--- | :--- |
|  マイニング  |  コインをマイニングできます．(確率で得られるコインの枚数が変化します．)  |
|  戻る  |  ホーム画面へ遷移します．  |


<a id="anchor9"></a>

#### ９．管理者画面

![admin](https://user-images.githubusercontent.com/106970558/212520721-0b304246-7079-4d40-8076-2bd8990a8118.png)

adminでログインしユーザのみが閲覧できます．
このページはでは以下の機能があります．

|  ボタン名  |  機能  |
| :--- | :--- |
|  全ユーザのコイン枚数を100枚にリセット  |  全ユーザのコイン枚数を100枚にします．  |
|  ルーム内のプレイヤーを全員退室  |  ルーム内のプレイヤーを全員退室させます．（全員がロビー画面にいない状態で実行してください．）  |
|  データベース更新  |  データベースを更新し表示される情報を最新のものにします．  |
|  戻る  |  ホーム画面へ遷移します．  |
