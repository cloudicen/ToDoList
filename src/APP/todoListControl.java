package APP;

import DAOFactory.DAOFactory;
import VO.taskVO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class todoListControl {
    public ListView<taskVO> taskList;

    ObservableList<taskVO> listItems;

    public void initialize() {
        listItems = FXCollections.observableArrayList();
        try {
            listItems.addAll(DAOFactory.getTaskDAOInstance().findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        taskList.setItems(listItems);
        taskList.setCellFactory(param -> new ListCell<taskVO>() {

            @Override
            protected void updateItem(taskVO item, boolean empty) {
                super.updateItem(item, empty);

                if (empty == false) {
                    HBox hbox = new HBox();

                    CheckBox state = new CheckBox();
                    state.setSelected(item.getIsFinished());
                    state.addEventHandler(ActionEvent.ACTION,event -> {
                        taskVO task = getItem();
                        task.setIsFinished(!task.getIsFinished());
                        try {
                            DAOFactory.getTaskDAOInstance().doUpdate(task);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                    TextArea details = new TextArea();
                    details.setText(item.getTaskInfo());
                    details.textProperty().addListener(new ChangeListener<String>() {
                        @Override
                        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                            taskVO task = getItem();
                            task.setTaskInfo(newValue);
                            try {
                                DAOFactory.getTaskDAOInstance().doUpdate(task);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    Label Done = new Label("Done!");

                    Button deleteBtn = new Button("Remove");
                    deleteBtn.addEventHandler(ActionEvent.ACTION,event -> {
                        taskVO task = getItem();
                        try {
                            DAOFactory.getTaskDAOInstance().doDelete(task);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        taskList.getItems().remove(item);
                    });

                    hbox.getChildren().addAll(Done,state, details, deleteBtn);
                    this.setGraphic(hbox);
                }
                else
                {
                    this.setGraphic(null);
                }
            }
        });
    }

    public void onAddTaskBtnPushed(ActionEvent event) {
        taskVO task = new taskVO();
        try {
            task.setTaskNo(DAOFactory.getTaskDAOInstance().doCreate(task));
        } catch (Exception e) {
            e.printStackTrace();
        }
        listItems.add(task);
    }
    // Todo：ui界面的逻辑控制代码
}
