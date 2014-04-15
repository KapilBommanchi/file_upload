package tenx.gwt.GwtFileUpload.server;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class GwtFileUploadImpl extends HttpServlet{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			   throws ServletException, IOException
			   {

			   //Set the root directory where you want to store the uploaded files
			   String rootDirectory = "/home/tenx/Desktop/uploaded/";
			   // Check that we have a file upload request
			   boolean read = ServletFileUpload.isMultipartContent(request);
			  
			   if (read)
			   {
			    // Create a factory for disk-based file items
			    FileItemFactory factory = new DiskFileItemFactory();
			    // Create a new file upload handler
			    ServletFileUpload upload = new ServletFileUpload(factory);
			  
			    // Process the uploaded items
			  
			    try {
			      // Parse the request
			      List items = upload.parseRequest(request);
			      // Process the uploaded items
			      Iterator iter = items.iterator();
			      while (iter.hasNext())
			      {
			       FileItem item = (FileItem) iter.next();
			     
			        String fileName = item.getName();
			        if (fileName != null && !fileName.equals(""))
			        {
			         fileName = FilenameUtils.getName(fileName);
			         File uploadedFile = new File(rootDirectory + fileName);
			       
			       
			         try {
			            item.write(uploadedFile);
			            //here set the root directory path
			            File newfile=new File(rootDirectory+uploadedFile.getName());
			            uploadedFile.renameTo(newfile);
			            response.getWriter().write(newfile.getName());
			          
			          }
			         catch (Exception e)
			         {
			           e.printStackTrace();
			         }
			       }
			      }
			     }
			    catch (FileUploadException e)
			    {
			     e.printStackTrace();
			    }
			   }
			   }
}