package classes;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

	private List list;

//	UI-Objects

	private Scene scn;
	private BorderPane brdrpn;
	private GridPane controls;
	private GridPane output;

	private ScrollPane scroll;

//	Controlobjects

	private TextField itemName;
	private Label itemN;
	private TextField itemName2;
	private Label itemN2;
	private TextField index;
	private Label ind;
	private Button addFirst;
	private Button addLast;
	private Button addIndex;
	private Button addBItem;
	private Button addAItem;
	private Button removeFirst;
	private Button removeLast;
	private Button removeIndex;
	private Button removeSpec;
	private Button removeBItem;
	private Button removeAItem;
	private Button sortByAlphabet;
	private Button addRNDMObjects;
	private TextField count;

	public void init() {

		list = new List(new Item("first"), new Item("last"));

//		Create controls

		controls = new GridPane();
		controls.setHgap(9);
		controls.setVgap(9);
		controls.setPadding(new Insets(18));

		itemName = new TextField("New Item 001");
		itemName.setMinSize(200, 50);
		itemName.setFont(new Font(20));
		controls.add(itemName, 1, 0);

		itemN = new Label("Itemname:");
		itemN.setFont(new Font(22));
		itemN.setTextFill(Color.WHITESMOKE);
		controls.add(itemN, 0, 0);

		index = new TextField("0");
		index.setMinSize(200, 50);
		index.setFont(new Font(20));
		index.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					index.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		controls.add(index, 1, 2);

		ind = new Label("Index:");
		ind.setFont(new Font(22));
		ind.setTextFill(Color.WHITESMOKE);
		controls.add(ind, 0, 2);

		itemName2 = new TextField("Reference Item");
		itemName2.setMinSize(200, 50);
		itemName2.setFont(new Font(20));
		controls.add(itemName2, 1, 1);

		itemN2 = new Label("Itemname 2:");
		itemN2.setFont(new Font(22));
		itemN2.setTextFill(Color.WHITESMOKE);
		controls.add(itemN2, 0, 1);

		addFirst = new Button("Add in First");
		addFirst.setMinSize(200, 50);
		addFirst.setOnAction(e -> {
			list.addInFirst(this.getItem());
			refreshListUI();
		});
		controls.add(addFirst, 0, 3);

		addLast = new Button("Add in Last");
		addLast.setMinSize(200, 50);
		addLast.setOnAction(e -> {
			list.addInLast(this.getItem());
			refreshListUI();
		});
		controls.add(addLast, 0, 4);

		addIndex = new Button("Add at Index");
		addIndex.setMinSize(200, 50);
		addIndex.setOnAction(e -> {
			list.addInIndex(this.getItem(), this.getIndex());
			refreshListUI();
		});
		controls.add(addIndex, 0, 5);

		removeLast = new Button("Remove Last");
		removeLast.setMinSize(200, 50);
		removeLast.setOnAction(e -> {
			list.removeLast();
			refreshListUI();
		});
		controls.add(removeLast, 1, 4);

		removeFirst = new Button("Remove First");
		removeFirst.setMinSize(200, 50);
		removeFirst.setOnAction(e -> {
			list.removeFirst();
			refreshListUI();
		});
		controls.add(removeFirst, 1, 3);

		removeIndex = new Button("Remove at Index");
		removeIndex.setMinSize(200, 50);
		removeIndex.setOnAction(e -> {
			list.removeAtIndex(this.getIndex());
			refreshListUI();
		});
		controls.add(removeIndex, 1, 5);

		addAItem = new Button("Add after Item");
		addAItem.setMinSize(200, 50);
		addAItem.setOnAction(e -> {
			list.addAfterItem(this.getItem(), this.getItem2());
			refreshListUI();
		});
		controls.add(addAItem, 0, 7);

		addBItem = new Button("Add before Item");
		addBItem.setMinSize(200, 50);
		addBItem.setOnAction(e -> {
			list.addBeforeItem(this.getItem(), this.getItem2());
			refreshListUI();
		});
		controls.add(addBItem, 0, 6);

		removeAItem = new Button("Remove after Item");
		removeAItem.setMinSize(200, 50);
		removeAItem.setOnAction(e -> {
			list.removeAfterItem(this.getItem2());
			refreshListUI();
		});
		controls.add(removeAItem, 1, 7);

		removeBItem = new Button("Remove before Item");
		removeBItem.setMinSize(200, 50);
		removeBItem.setOnAction(e -> {
			list.removeBeforeItem(this.getItem2());
			refreshListUI();
		});
		controls.add(removeBItem, 1, 6);

		removeSpec = new Button("Remove specific Item");
		removeSpec.setMinSize(200, 50);
		removeSpec.setOnAction(e -> {
			list.removeSpecificItem(getItem2());
			refreshListUI();
		});
		controls.add(removeSpec, 1, 8);

		sortByAlphabet = new Button("Sort by Alphabet");
		sortByAlphabet.setMinSize(200, 50);
		sortByAlphabet.setOnAction(e -> {
			list.sortByAlphabet();
			refreshListUI();
		});
		controls.add(sortByAlphabet, 0, 8);

		count = new TextField("20");
		count.setMinSize(200, 50);
		count.setFont(new Font(20));
		count.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					count.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		controls.add(count, 0, 9);

		addRNDMObjects = new Button("Create Random Objects");
		addRNDMObjects.setMinSize(200, 50);
		addRNDMObjects.setOnAction(e -> {
			createRNDMObjects(getCount());
			refreshListUI();
		});
		controls.add(addRNDMObjects, 1, 9);

//		Create output

		output = new GridPane();
		output.setHgap(7);
		output.setVgap(18);
		output.setPadding(new Insets(18));

		scroll = new ScrollPane();
		scroll.setContent(output);
		scroll.setPrefWidth(500);
		scroll.setStyle("-fx-base: transparent; -fx-background-color: transparent;");

		refreshListUI();

	}

	private void createRNDMObjects(int count) {
		String t = "";
		for (int i = 0; i < Math.abs(count); i++) {
			for (int j = 0; j < 5; j++) {
				t = t + Character.toString((char) ((int) (Math.random() * 26) + 'A'));
			}
			list.addInLast(new Item(t));
			t = "";
		}
	}

	public void refreshListUI() {

		output.getChildren().clear();

		for (int i = 0; i < list.getSize(); i++) {
			Label item = new Label(list.getPerIndex(i).getName());
			item.setFont(new Font(22));
			item.setTextFill(Color.WHITESMOKE);
			output.add(item, 1, i);

			Label ic = new Label(i + " : ");
			ic.setFont(new Font(22));
			ic.setTextFill(Color.WHITESMOKE);
			output.add(ic, 0, i);

		}
	}

	private Item getItem() {

		return new Item(itemName.getText());
	}

	private Item getItem2() {

		return list.getPerName(itemName2.getText());
	}

	private int getIndex() {
		try {
			return Integer.parseInt(index.getText());
		} catch (NumberFormatException e) {
			return 0;
		}

	}

	private int getCount() {
		try {
			return Integer.parseInt(count.getText());
		} catch (NumberFormatException e) {
			return 0;
		}

	}

	@Override
	public void start(Stage stg) {

		brdrpn = new BorderPane();
		brdrpn.setLeft(controls);
		brdrpn.setCenter(scroll);
		brdrpn.setBackground(null);
		scn = new Scene(brdrpn, 666, 666, true);
		scn.setFill(Color.rgb(40, 6, 60));

		stg.setScene(scn);
		stg.setTitle("List");
		stg.getIcons().add(new Image(getClass().getResourceAsStream("../img/icon.png")));

		scn.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent e) {
				if (e.getCode() == KeyCode.F11) {
					stg.setFullScreen(!stg.isFullScreen());
				}
			}
		});

		stg.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
