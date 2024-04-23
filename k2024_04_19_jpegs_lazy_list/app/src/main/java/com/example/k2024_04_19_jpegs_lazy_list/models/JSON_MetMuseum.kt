package com.example.k2024_04_19_jpegs_lazy_list.models

data class JSON_MetMuseum(
    val GalleryNumber: String,
    val accessionNumber: String,
    val accessionYear: String,
    val additionalImages: List<Any>,
    val artistAlphaSort: String,
    val artistBeginDate: String,
    val artistDisplayBio: String,
    val artistDisplayName: String,
    val artistEndDate: String,
    val artistGender: String,
    val artistNationality: String,
    val artistPrefix: String,
    val artistRole: String,
    val artistSuffix: String,
    val artistULAN_URL: String,
    val artistWikidata_URL: String,
    val city: String,
    val classification: String,
    val constituents: Any,
    val country: String,
    val county: String,
    val creditLine: String,
    val culture: String,
    val department: String,
    val dimensions: String,
    val dynasty: String,
    val excavation: String,
    val geographyType: String,
    val isHighlight: Boolean,
    val isPublicDomain: Boolean,
    val isTimelineWork: Boolean,
    val linkResource: String,
    val locale: String,
    val locus: String,
    val measurements: Any,
    val medium: String,
    val metadataDate: String,
    val objectBeginDate: Int,
    val objectDate: String,
    val objectEndDate: Int,
    val objectID: Int,
    val objectName: String,
    val objectURL: String,
    val objectWikidata_URL: String,
    val period: String,
    val portfolio: String,
    val primaryImage: String,
    val primaryImageSmall: String,
    val region: String,
    val reign: String,
    val repository: String,
    val rightsAndReproduction: String,
    val river: String,
    val state: String,
    val subregion: String,
    val tags: Any,
    val title: String
)