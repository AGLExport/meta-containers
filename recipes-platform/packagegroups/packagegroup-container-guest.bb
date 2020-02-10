SUMMARY = "The basic component set for container guest."
DESCRIPTION = "The set of packages required for container guest image."
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-container-guest \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    can-utils \
"

