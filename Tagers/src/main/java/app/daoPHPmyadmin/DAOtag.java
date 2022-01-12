package app.daoPHPmyadmin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import app.iServiceDAO.IDAOmanageTag;
import app.model.Ping;
import app.model.Tag;
import utilities.SimpleIdAssociationCom;

@Repository("DAOtag")
public class DAOtag implements IDAOmanageTag {
	MySingleton singleton = MySingleton.getInstance();
	Connection conn = singleton.getConn(); // establishing connection

	@Override
	public boolean verifyOwnershipTag(SimpleIdAssociationCom t) {
		String userid = t.getUserid();
		String tagid = t.getWhatever();

		String _userid = "";

		try {
			Statement ps;
			ResultSet rs;
			String requete = "SELECT `IDuser` FROM `tag` WHERE `IDtag` ='"
					+ (String) tagid + "'";
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				_userid = rs.getString("IDuser");
			}
			rs.close();
			ps.close();

			if (userid.equals(_userid))
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.println("exeption");
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public boolean verifyOwnershipTracker(SimpleIdAssociationCom t) {
		String userid = t.getUserid();
		String trackerid = t.getWhatever();

		String _userid = "";

		try {
			Statement ps;
			ResultSet rs;
			String requete = "SELECT `IDuser` FROM `tracker` WHERE `IDtracker` ='"
					+ (String) trackerid + "'";
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {
				_userid = rs.getString("IDuser");
			}
			rs.close();
			ps.close();

			if (userid.equals(_userid))
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.println("exeption");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String addTag(Tag t) {

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
					+ " VALUES ('" + IDtag + "' , '" + IDman + "' , '" + IDuser
					+ "' , '" + Tagname + "', " + time + " , " + x + "  ," + y
					+ ")";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();
			return (IDtag);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");
		}
	}

	@Override
	public String deleteTag(Tag t) {

		String IDtag = t.getIDtag();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `tag` WHERE `IDtag` ='" + IDtag
					+ "'; ";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();
			return (IDtag + " deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");

		}

	}

	@Override
	public String rLost(String tagid) {

		// String IDtag = t.getIDtag();

		String tagname = "";
		try {
			Statement ps;
			ResultSet rs;
			String requete = " INSERT INTO LostTags (IDtag) VALUES ('"
					+ tagid.toString() + "');";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			String gettagname = "SELECT `Tagname` FROM `Tag` WHERE `IDtag`='"
					+ tagid + "'";

			rs = ps.executeQuery(gettagname);
			while (rs.next()) {

				tagname = rs.getString("Tagname");

			}

			ps.close();
			rs.close();

			return (tagname + " is now lost");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");
		}
	}

	@Override
	public String rFound(Ping p) {
		String idtag = p.gettID();
		float x = p.getX();
		float y = p.getY();
		float dt = p.getDate();
		try {
			Statement ps;
			// ResultSet rs;
			String requete = "UPDATE `tag` " + "SET `Lastpingtime`=" + dt
					+ ", `LastpingtimeX`=" + x + ", `Lastpingtimey`=" + y
					+ " WHERE `IDtag`='" + idtag + "'";

			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

			return ("tag updated");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");
		}
	}

	@Override
	public String rRecoverd(Tag t) {
		String IDtag = t.getIDtag();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " DELETE FROM `LostTags` WHERE `IDtag` ='" + IDtag
					+ "'; ";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

			return (IDtag + "Recoverd");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");
		}

	}

	@Override
	public String renameTag(Tag t, String newname) {
		String tagid = t.getIDtag();

		try {
			Statement ps;
			// ResultSet rs;
			String requete = " UPDATE `Tag` SET `Tagname`='" + newname
					+ "' WHERE `IDtag`='" + tagid + "'";
			ps = conn.createStatement();
			ps.executeUpdate(requete);

			ps.close();

			return (tagid + " renamed");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
			return ("error");
		}

	}

	@Override
	public HashMap<String, String> pingMe(SimpleIdAssociationCom jcom) {
		String tagid = jcom.getWhatever();

		HashMap<String, String> Jres = new HashMap<>();
		try {
			Statement ps;
			ResultSet rs;
			String requete = "SELECT * FROM `tag` WHERE `IDtag` ='"
					+ (String) tagid + "'";
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			while (rs.next()) {

				Jres.put("tagid", tagid);
				String IDman = rs.getString("IDman");
				Jres.put("manid", IDman);
				String IDuser = rs.getString("IDuser");
				Jres.put("userID", IDuser);
				String tagname = rs.getString("Tagname");
				Jres.put("tagname", tagname);
				Float dt = rs.getFloat("Lastpingtime");
				Float x = rs.getFloat("LastpingtimeX");
				Float y = rs.getFloat("Lastpingtimey");
				Ping p = new Ping(tagid, x, y);
				p.setDate(dt);
				Jres.put("longitude", x.toString());
				Jres.put("latitude", y.toString());
				Jres.put("last ping", p.toStringDate());

			}

			rs.close();
			ps.close();

			return Jres;
		} catch (SQLException e) {
			System.out.println("exeption");
			e.printStackTrace();
			Jres.put("response", "error");
			return Jres;
		}

	}
}
