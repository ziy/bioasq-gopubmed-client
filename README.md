BioASQ GoPubMed Service Client
==============================

Java client and [Gson](https://code.google.com/p/google-gson/) objects for [GoPubMed](http://gopubmed.org/web/gopubmed/) services used for [BioASQ task](http://bioasq.org/), which can be configured to directly access the official gopubmed.org server, or access a remote proxy server which can cache and reroute the request to reduce request frequency through properties file.

An example can be found [here](src/main/java/edu/cmu/lti/oaqa/bio/bioasq/services/GoPubMedServiceExample.java).

Use in a Maven project
-------------------------

Configure your pom.xml by adding this repository

```xml
<repository>
  <id>ziy-mvnrepo-releases</id>
  <name>ziy GitHub Personal Repo</name>
  <url>https://raw.github.com/ziy/mvn-releases/master/</url>
</repository>
```

and adding this dependency

```xml
<dependency>
  <groupId>edu.cmu.lti.oaqa.bio</groupId>
  <artifactId>bioasq-gopubmed-client</artifactId>
  <version>0.0.6</version>
</dependency>
```

Properties syntax
-----------------
**DEIIS students:** Please see the course project instruction to configure your _hwX-ID.properties_ file.

**Others:**

```
pubmed.search.service = PUBMED_SEARCH_SERVICE_URL
linked.life.data.service = LINKED_LIFE_DATA_SERVICE_URL
disease.ontology.service = DISEASE_ONTOLOY_SERVICE_URL
gene.ontology.service = GENE_ONTOLOGY_SERVICE_URL
jochem.service = JOCHEM_SERVICE_URL
mesh.service = MESH_SERVICE_URL
uniprot.service = UNIPROT_SERVICE_URL
require.session.url = true
```

1. The values of the properties should be configured according to the instruction, e.g. http://gopubmed.org/web/gopubmedbeta/bioasq/pubmed.
2. "require.session.url = true" is required for the official service, but for accessing proxy server, which may be set to _false_.
3. According to [Apache Commons Configuration](https://commons.apache.org/proper/commons-configuration/userguide/howto_properties.html#Using_PropertiesConfiguration), the configuration file should be placed in the current directory, in the user home directory, or in the classpath.
