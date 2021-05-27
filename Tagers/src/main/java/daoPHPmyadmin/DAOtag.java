package daoPHPmyadmin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import iServiceDAO.IDAOmanageTag;
import model.Ping;
import model.Tag;

public class DAOtag implements IDAOmanageTag {
	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn(); // establishing connection

	@Override
	public void addTag(Tag t) {

		String IDtag= t.getIDtag();
		String IDman= t.getIDman();
		String IDtracker= t.getIDtracker();
		String Tagname= t.getTagName();
		Ping lastping= t.getLastping();
		float x= lastping.getX();
		float y= lastping.getY();
		float time= lastping.getDate();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "INSERT INTO tag (IDtag, IDman,IDtracker,Tagname,Lastpingtime,LastpingtimeX,Lastpingtimey)"
					+ " VALUES ('"+ IDtag +"' , '"+IDman+"' , '"+IDtracker+"' , '"+Tagname+"', "+time+" , "+x+"  ,"+y+")";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
	}

	

	@Override
	public void deleteTag(Tag t) {
		// TODO Auto-generated method stub
		String IDtag= t.getIDtag();
		
		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `tag` WHERE IDtag =" +IDtag +"; ";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}

	}

	@Override
	public void rLost(Tag t) {
		// TODO Auto-generated method stub
		String IDtag= t.getIDtag();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = " INSERT INTO LostTags (IDtag) VALUES ('"+IDtag+"');";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
	}

	@Override
	public void rFound(Ping p) {
		float x= p.getX();
		float y=p.getY();
		float dt=p.getDate();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "INSERT INTO tag (Lastpingtime,LastpingtimeX,Lastpingtimey)"
					+ " VALUES ("+x+" , "+y+"  ,"+dt+")";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
	}


	@Override
	public void rRecoverd(Tag t) {
		String IDtag= t.getIDtag();
		
		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `LostTags` WHERE IDtag ='" +IDtag +"'; ";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		
	}



	@Override
	public void renameTag(Tag t) {
		// TODO Auto-generated method stub
		
	}

}
