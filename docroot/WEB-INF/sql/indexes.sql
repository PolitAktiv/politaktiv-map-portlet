create index IX_14675B18 on politaktivmap_Background (companyId, groupId);

create index IX_EA9F5983 on politaktivmap_DbMapObject (companyId, groupId);

create index IX_5061FC69 on politaktivmap_DbMarker (markerId);

create index IX_240B62A5 on politaktivmap_DbPicture (pictureId);

create index IX_F5CBA0E5 on politaktivmap_DbPoint (pointId);

create index IX_BA3B0CBF on politaktivmap_Marker (backgroundId);

create index IX_A5D6287F on politaktivmap_Picture (backgroundId);
create index IX_8A9F5BA1 on politaktivmap_Picture (name);