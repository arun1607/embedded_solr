package com.app.learning;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.core.CoreContainer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by amits on 29/07/15.
 */
public class App {
	public static void main(String[] args) throws IOException, SolrServerException {
		Path solrHome = FileSystems.getDefault().getPath("src/main/resources/solr");
		SolrClient embeddedSolrServer = new EmbeddedSolrServer(solrHome,"employees");
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("qt", "/dataimport");
		params.set("command", "full-import");

		embeddedSolrServer.query("employees", params);
	}
}
