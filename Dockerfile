# ベースイメージとしてJDKを使用
FROM eclipse-temurin:21-jdk as builder

# 作業ディレクトリを設定
WORKDIR /app

# プロジェクトの全ファイルをコンテナにコピー
COPY . /app

# Mavenをインストールしてプロジェクトをビルド
RUN apt-get update && apt-get install -y maven \
  && ./mvnw clean package -DskipTests

# 実行環境用の軽量JREベースイメージ
FROM eclipse-temurin:21-jre

# 一時ファイルの保存場所として/tmpディレクトリを設定
VOLUME /tmp

# ビルド成果物をコピー
COPY --from=builder /app/target/my-menu-app-spring-0.0.1-SNAPSHOT.jar my-menu-app.jar

# アプリケーションを実行
ENTRYPOINT ["java","-jar","/my-menu-app.jar"]