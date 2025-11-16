package Lala_IRL;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connect = null;
	private Statement statement = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter();
		
		try{
			out.println( "Registering  JDBC driver");
			//STEP 1: Register JDBC driver. This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			out.println( "Setting up the connection with the DB");
			//STEP 2: Open a connection. Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://localhost/Lala_IRL","root" ,"" );
            // STEP 3: Statements allow us to  issue SQL queries to the database
			statement = connect.createStatement();
			out.println("2nd test");
			//STEP 4: declare a query
			String sql = "INSERT INTO products (id, productname, brand, price, qty, img) VALUES" +
		    		"(101,'Charlotte Tilbury - Pillow Talk Lipstick', 'Charlotte Tilbury', 37, 50, 'assets/assets/charlotte-tilbury-lipstick.jpg')," +
		    		"(102,'NARS - Radiant Creamy Concealer', 'NARS', 30, 10, 'assets/nars-concealer.jpg'),"+
		    		"(103,'e.l.f. - Power Grip Primer', 'e.l.f.', 12, 25, 'assets/elf-primer.jpg'),"+
		    		"(104,'Charlotte Tilbury - Airbrush Flawless Foundation', 'Charlotte Tilbury', 50, 46, 'assets/charlotte-tilbury-foundation.jpg')," +
		    		"(105,'Rare Beauty - Soft Pinch Liquid Blush', 'Rare Beauty', 30, 40, 'assets/rare-beauty-blush.jpg'),"+
		    		"(106,'Fenty Beauty - Pro Filt'r Foundation', 'Fenty Beauty', 40, 36, 'assets/fenty-foundation.jpg')," +
		    		"(107,'e.l.f. - Halo Glow Liquid Filter', 'e.l.f.', 15, 50, 'elf-halo-glow.jpg'),"+
		    		"(108,'NARS - Orgasm Blush', 'NARS', 30, 36, 'assets/nars-orgasm-blush.jpg')," +
		    		"(109,'Charlotte Tilbury - Magic Cream', 'Charlotte Tilbury', 95, 36, 'assets/maybelline-mascara.jpg')," +
		    		"(110,'Maybelline - Lash Sensational Mascara', 'Maybelline', 16, 36, 'assets/elf-halo-glow.jpg')," +
					"(111,'Glossier - Boy Brow', 'Glossier', 18, 36, 'assets/glossier-boy-brow.jpg')," +
					"(112,'Dior - Lip Glow Oil', 'Dior', 56, 36, 'assets/dior-lip-oil.jpg'),";
			//STEP 5: execute a query
			statement.executeUpdate(sql);
			out.println( "Data insert.....");
			
		}catch (Exception e){
			
		}// Exception
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
