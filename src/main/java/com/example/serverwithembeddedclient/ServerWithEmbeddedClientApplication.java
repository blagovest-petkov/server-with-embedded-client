package com.example.serverwithembeddedclient;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ServerWithEmbeddedClientApplication extends Application implements ApplicationListener<ApplicationReadyEvent> {

	public static void main(String[] args) {
		new Thread(() -> ServerInitializer.run(args)).start();
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("JavaFX WebView Example");

		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();

		webEngine.load("http://localhost:8080/");

		VBox vBox = new VBox(webView);
		Scene scene = new Scene(vBox, 1200, 800);

		stage.setScene(scene);
		stage.show();
	}
}
