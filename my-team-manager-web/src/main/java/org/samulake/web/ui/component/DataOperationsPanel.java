package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;

public class DataOperationsPanel extends Panel {
    private Button addButton;
    private Button editButton;
    private Button deleteButton;
    private Button cancellButton;

    private DataOperationsPanel(DataOperationsPanelBuilder builder) {
        this.addButton = builder.addButton;
        this.editButton = builder.editButton;
        this.deleteButton = builder.deleteButton;
        this.cancellButton = builder.cancellButton;
        setContent(builder.layout);
    }

    public Button getAddButton() {
        return addButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public Button getCancellButton() {
        return cancellButton;
    }

    public static class DataOperationsPanelBuilder {
        private Button addButton;
        private Button editButton;
        private Button deleteButton;
        private Button cancellButton;

        private AbstractLayout layout;

        public DataOperationsPanelBuilder(AbstractLayout layout) {
            this.layout = layout;
        }

        public DataOperationsPanelBuilder withAddButton() {
            addButton = new Button("Add");
            layout.addComponent(addButton);
            return this;
        }

        public DataOperationsPanelBuilder withEditButton() {
            editButton = new Button("Edit");
            layout.addComponent(editButton);
            return this;
        }

        public DataOperationsPanelBuilder withDeleteButton() {
            deleteButton = new Button("Delete");
            layout.addComponent(deleteButton);
            return this;
        }

        public DataOperationsPanelBuilder withCancellButton() {
            cancellButton = new Button("Cancell");
            layout.addComponent(cancellButton);
            return this;
        }

        public DataOperationsPanelBuilder withAddEditDeleteButtons() {
            return withAddButton().withEditButton().withDeleteButton();
        }

        public DataOperationsPanel build() {
            return new DataOperationsPanel(this);
        }
    }
}
