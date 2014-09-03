BioASQ GoPubMed Service Client
==============================

Java client and [Gson](https://code.google.com/p/google-gson/) objects for [GoPubMed](http://gopubmed.org/web/gopubmed/) services used for [BioASQ task](http://bioasq.org/), which can be configured to directly access the official gopubmed.org server, or access a remote proxy server which can cache and reroute the request to reduce request frequency through properties file.

An example can be found [here](src/main/java/edu/cmu/lti/oaqa/bio/bioasq/services/GoPubMedServiceExample.java).

Properties syntax
-----------------
**DEIIS students:** Please see project instruction to configure your _hwX-ID.properties_ file.

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

**Note**
1. The values of the properties should be configured according to the instruction, e.g. http://gopubmed.org/web/gopubmedbeta/bioasq/pubmed.
2. "require.session.url = true" is required for the official service, but for accessing proxy server, which may be set to _false_.
3. According to [Apache Commons Configuration](https://commons.apache.org/proper/commons-configuration/userguide/howto_properties.html#Using_PropertiesConfiguration), the configuration file should be placed in the current directory, in the user home directory, or in the classpath.
