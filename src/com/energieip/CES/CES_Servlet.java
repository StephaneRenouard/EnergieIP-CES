package com.energieip.CES;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.energieip.api.EnergieAPI;

/**
 * Servlet implementation class CES_Servlet
 */
@WebServlet("/CES_Servlet")
public class CES_Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private EnergieAPI energieAPI;
    private AutoMod autoMod;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CES_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[INIT] Servlet CES_Servlet init request");
		
		
		System.out.println("[INIT] Servlet CES_Servlet initialized");
		
		energieAPI = new EnergieAPI();
		
		autoMod = new AutoMod(energieAPI);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
       
        // System.out.println("doGet with param=" + request.getContentLength());
        String param1 = request.getParameter( "param1" );
        String param2 = request.getParameter( "param2" );
       
        System.out.println("doGet param1=" + param1 + " param2=" + param2);
        
        try {
        
        if(param1.matches("A")) { // rond
        		
        		AutoMod.auto = false;
        	
        		int varia = Integer.parseInt(param2);
            	energieAPI.setIndividualLightPercentage(21, varia);
            
        }else if(param1.matches("B")){ // milane
        		
        		AutoMod.auto = false;
    		
        		int varia = Integer.parseInt(param2);
            	energieAPI.setIndividualLightPercentage(44, varia);
            	
        }else if(param1.matches("C")){ // carré
        			
        		AutoMod.auto = false;
    		
        		int varia = Integer.parseInt(param2);
        		energieAPI.setIndividualLightPercentage(16, varia);
        		
        }else if(param1.matches("D")){ // groupe
    		
        	AutoMod.auto = false;
    		
        	int varia = Integer.parseInt(param2);
    		energieAPI.setGroupLightPercentage(2, varia);
    		
        }else if(param1.matches("up")){ // 
    		
        	AutoMod.auto = false;
    		
        	
        	energieAPI.setShutterUp(406);
        }
        else if(param1.matches("stop")){ // 
        	AutoMod.auto = false;
    		
        	energieAPI.setShutterStop(406);
        }
        else if(param1.matches("down")){ // 
        	AutoMod.auto = false;
    		
        	energieAPI.setShutterDown(406);
        }
        else if(param1.matches("auto")){ // 
        	AutoMod.auto = true;
    		
        }else {
        	// do nothing
        }
        	
        }
        catch (Exception e) {
        	System.out.println("param2 is invalid");
		}
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
