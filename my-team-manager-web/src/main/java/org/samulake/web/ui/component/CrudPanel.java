package org.samulake.web.ui.component;

import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;

public class CrudPanel extends Panel {
    private Button addButton;
    private Button editButton;
    private Button deleteButton;

    private AbstractLayout layout;

    public CrudPanel(CrudPanelBuilder builder) {
        this.addButton = builder.addButton;
        this.editButton = builder.editButton;
        this.deleteButton = builder.deleteButton;
        setContent(builder.layout);
    }

    public Button getAddButton() {
        return addButton;
    }

    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public static class CrudPanelBuilder {
        private Button addButton;
        private Button editButton;
        private Button deleteButton;

        private AbstractLayout layout;

        public CrudPanelBuilder(AbstractLayout layout) {
            this.layout = layout;
        }

        public CrudPanelBuilder withAddButton() {
            addButton = new Button("Add");
            layout.addComponent(addButton);
            return this;
        }

        public CrudPanelBuilder withEditButton() {
            editButton = new Button("Edit");
            layout.addComponent(editButton);
            return this;
        }

        public CrudPanelBuilder withDeleteButton() {
            deleteButton = new Button("Delete");
            layout.addComponent(deleteButton);
            return this;
        }

        public CrudPanelBuilder withAddEditDeleteButtons() {
            return withAddButton().withEditButton().withDeleteButton();
        }

        public CrudPanel build() {
            return new CrudPanel(this);
        }
    }
}