package tenx.gwt.GwtFileUpload.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormSubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormSubmitEvent;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

@SuppressWarnings("deprecation")
public class GwtFileUpload implements EntryPoint {
	private static final String url = GWT.getModuleBaseURL() + "upload";

	@SuppressWarnings("deprecation")
	@Override
	public void onModuleLoad() {
		// TODO Auto-generated method stub
		final FormPanel form = new FormPanel();
		form.setAction(url);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		form.setMethod(FormPanel.METHOD_POST);
		
		VerticalPanel panel = new VerticalPanel();
		form.setWidget(panel);
		
		FileUpload upload = new FileUpload();
		upload.setName("fileupload");
		panel.add(upload);
		
		Button submitform = new Button("submit");
		panel.add(submitform);
		
		submitform.addClickListener(new ClickListener() {
		      public void onClick(final Widget sender) {
		        form.submit();
		      }
		    }); 
		
		form.addFormHandler(new FormHandler() {
		     
			@Override
			@Deprecated
			public void onSubmit(FormSubmitEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			@Deprecated
			public void onSubmitComplete(FormSubmitCompleteEvent event) {
				// TODO Auto-generated method stub
				 Window.alert("file uploaded");
			}
		    }); 
		
		 
		 RootPanel.get("upload").add(form);
		 
	}

}
