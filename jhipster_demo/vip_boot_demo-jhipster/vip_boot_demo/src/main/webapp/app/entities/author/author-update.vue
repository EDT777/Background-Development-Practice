<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="vip1App.author.home.createOrEditLabel" v-text="$t('vip1App.author.home.createOrEditLabel')">Create or edit a Author</h2>
                <div>
                    <div class="form-group" v-if="author.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="author.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.author.name')" for="author-name">Name</label>
                        <input type="text" class="form-control" name="name" id="author-name"
                            :class="{'valid': !$v.author.name.$invalid, 'invalid': $v.author.name.$invalid }" v-model="$v.author.name.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.author.pct')" for="author-pct">Pct</label>
                        <input type="text" class="form-control" name="pct" id="author-pct"
                            :class="{'valid': !$v.author.pct.$invalid, 'invalid': $v.author.pct.$invalid }" v-model="$v.author.pct.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.author.valid')" for="author-valid">Valid</label>
                        <input type="checkbox" class="form-check" name="valid" id="author-valid"
                            :class="{'valid': !$v.author.valid.$invalid, 'invalid': $v.author.valid.$invalid }" v-model="$v.author.valid.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.author.createDate')" for="author-createDate">Create Date</label>
                        <div class="d-flex">
                            <input id="author-createDate" type="datetime-local" class="form-control" name="createDate" :class="{'valid': !$v.author.createDate.$invalid, 'invalid': $v.author.createDate.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.author.createDate.$model)"
                            @change="updateZonedDateTimeField('createDate', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('vip1App.author.level')" for="author-level">Level</label>
                        <input type="number" class="form-control" name="level" id="author-level"
                            :class="{'valid': !$v.author.level.$invalid, 'invalid': $v.author.level.$invalid }" v-model.number="$v.author.level.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.author.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./author-update.component.ts">
</script>
