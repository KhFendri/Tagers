package app.daoPHPmyadmin;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import app.iServiceDAO.IDAOmanageTag;
import app.model.Ping;
import app.model.Tag;

@Repository("DAOtag")
public class DAOtag implements IDAOmanageTag {
	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn(); // establishing connection

	@Override
	public void addTag(Tag t) {

		String IDtag = t.getIDtag();
		String IDman = t.getIDman();
		String IDuser = t.getIDuser();
		String Tagname = t.getTagName();
		Ping lastping = t.getLastping();
		float x = lastping.getX();
		float y = lastping.getY();
		float time = lastping.getDate();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "INSERT INTO tag (IDtag, IDman,IDuser,Tagname,Lastpingtime,LastpingtimeX,Lastpingtimey)"
					+ " VALUES ('" + IDtag + "' , '" + IDman + "' , '" + IDuser + "' , '" + Tagname + "', " + time
					+ " , " + x + "  ," + y + ")";
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

		String IDtag = t.getIDtag();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `tag` WHERE `IDtag` ='" + IDtag + "'; ";
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
		String IDtag = t.getIDtag();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = " INSERT INTO LostTags (IDtag) VALUES ('" + IDtag + "');";
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
		String idtag = p.gettID();
		float x = p.getX();
		float y = p.getY();
		float dt = p.getDate();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "INSERT INTO `tag` (`Lastpingtime`,`LastpingtimeX`,`Lastpingtimey`) WHERE `IDtag` ='"
					+ idtag + "'" + " VALUES (" + x + " , " + y + "  ," + dt + ")";
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
		String IDtag = t.getIDtag();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `LostTags` WHERE `IDtag` ='" + IDtag + "'; ";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}

	}

	@Override
	public void renameTag(Tag t, String newname) {
		String tagid = t.getIDtag();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " UPDATE `Tag` SET `Tagname`='" + newname + "' WHERE `IDtag`='" + tagid + "'";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}

	}

}