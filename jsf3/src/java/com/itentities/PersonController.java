package com.itentities;

import com.itentities.util.JsfUtil;
import com.itentities.util.JsfUtil.PersistAction;
import java.io.IOException;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("personController")
@SessionScoped
public class PersonController implements Serializable {

    @EJB
    private com.itentities.PersonFacade ejbFacade;
    private List<Person> items = null;
    private Person selected;

    public PersonController() {
    }

    public Person getSelected() {
      if(selected==null)
        {
            selected=new Person();
        }
      
        return selected;
    }
    

    public void setSelected(Person selected) {
        this.selected = selected;
    }
public void Haha() throws IOException
    {
        Person l=getPerson(selected.getMId());
        if(l==null)
        {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/NO.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(l.getMPassword().equals(selected.getMPassword()))
        {
           /* try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/Yes.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
           System.out.print("l"+l.getMAuthority()+"      "+"s"+selected.getMAuthority());
           if(l.getMAuthority().equals("1")){
               Company company=new Company();
               company.setMId(getPerson(selected.getMId()));
              
               FacesContext.getCurrentInstance().getExternalContext().redirect("faces/person1.xhtml");
           }
           else if(l.getMAuthority().equals("2")){
               FacesContext.getCurrentInstance().getExternalContext().redirect("faces/person2.xhtml");
           }
           else{
               selected=getPerson(selected.getMId());
               FacesContext.getCurrentInstance().getExternalContext().redirect("faces/person3.xhtml");
           }
            
        }else
        {
              try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/NO.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PersonFacade getFacade() {
        return ejbFacade;
    }

    public Person prepareCreate() {
        selected = new Person();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PersonCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PersonUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PersonDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Person> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Person getPerson(java.math.BigDecimal id) {
        return getFacade().find(id);
    }

    public List<Person> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Person> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Person.class)
    public static class PersonControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PersonController controller = (PersonController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "personController");
            return controller.getPerson(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Person) {
                Person o = (Person) object;
                return getStringKey(o.getMId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Person.class.getName()});
                return null;
            }
        }

    }

}
