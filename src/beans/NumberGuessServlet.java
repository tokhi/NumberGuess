package beans;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class NumberGuessServlet
 */
public class NumberGuessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String render;
    private String render2;
    private boolean sukses;
    private Map<String,String>viewMap;
	private String txt;
	private int gc=0;
	private int count;
	private String viewFile;
	NumberGussBeans ngb;
	private int NGB_GUESS = 0;
	private String render4;
	private String render3;
	private String name;
	private int guessed=0;
	private boolean nameSent = true;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumberGuessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
			render = config.getInitParameter("render");
			render2 = config.getInitParameter("render2");
			render3 = config.getInitParameter("render3");
			render4 = config.getInitParameter("render4");
		
		viewMap = new HashMap<String,String>();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("model")==null){
			session.setAttribute("model", new NumberGussBeans());
		}
		
		ngb = (NumberGussBeans) session.getAttribute("model");
		
		try {
			if(nameSent == false){
				guessed = Integer.parseInt(request.getParameter("guessed"));
			}
			else{
				guessed = 0;
				name = request.getParameter("named");
				ngb.setName(name);
				//System.out.print("name: "+name);
				
			}
			
			//System.out.print("name: "+name);
			
			ngb.setGuess(guessed);
			txt = ngb.getMsg();
			gc = ngb.getGUESS_CONDITION();
			count = ngb.getCounter();
			if(nameSent == true){
				txt = "Welcome : "+name;
				ngb.init();
				nameSent = false;
			}
			
		} catch (Exception e) {
			viewMap.put("response", "only number allowed to be enter!");
			e.printStackTrace();
		}
		
		//Attach to request
		//viewMap.
		//
		
		// Forward to View
		
		//request.setAttribute("ViewMap", viewMap);
		//correct guess
		System.out.println(count+" gc: "+gc+" "+nameSent);
		if(gc == 2){
			//ngb.setView("success.jsp");
			//viewFile = ngb.getView();
			gc = 1;
			nameSent = true;
			viewMap.put("response", name+": "+txt);
			request.setAttribute("ViewMap", viewMap);
			RequestDispatcher view = request.getRequestDispatcher(render2);
			view.forward(request, response);
			
		}
		else if(gc == 1){
			viewMap.put("response", txt);
			request.setAttribute("ViewMap", viewMap);
			RequestDispatcher view = request.getRequestDispatcher(render4);
			view.forward(request, response);
		}
		else{
			viewMap.put("response", txt);
			request.setAttribute("ViewMap", viewMap);
			RequestDispatcher view = request.getRequestDispatcher(render3);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
